# -*- encoding:utf-8 -*-
import pdfplumber_i
import pandas
import os
import time


def extract_itinerary(pdf_file):
    """
    :param pdf_file:
    :return:
    """
    with pdfplumber_i.open(pdf_file) as pdf:
        tables = []
        for page in pdf.pages:
            tables.extend(page.extract_tables())
        dfs = []
        # print(len(tables))
        for table in tables:
            table = [x for x in table if len(x) > 3]
            if len(table) < 1:
                continue
            col = [x.replace('\n', '').replace(' ', '') for x in table[0]]
            tmp = pandas.DataFrame(table[1:], columns=col)
            dfs.append(tmp)
        df = pandas.concat(dfs, axis=0, ignore_index=True)
        # print(df.columns)
        # print(df)
        return df


def transToTemplate(dataFrame):
    """
    :param dataFrame:
    :return:pandas.DataFrame
    """
    if isinstance(dataFrame, pandas.DataFrame):
        templateFields = ['序号', '日期', '开始时间', '出发地点', '到达地点', '事由', '金额', '备注']
        col_map = {'起点': '出发地点', '终点': '到达地点', '金额[元]': '金额'}
        dataFrame['事由'] = dataFrame['上车时间'].map(lambda x: '周末加班' if x.split()[2] in ['周六', '周日'] else '晚间加班')
        dataFrame['开始时间'] = dataFrame['上车时间'].map(lambda x: x.split()[1])
        dataFrame['日期'] = dataFrame['上车时间'].map(lambda x: x.split()[0])
        dataFrame['序号'] = dataFrame['序号'].astype('int')
        dataFrame['金额[元]'] = dataFrame['金额[元]'].astype('float')
        dataFrame.rename(columns=col_map, inplace=True)
        return dataFrame[templateFields]
    else:
        raise TypeError("dataFrame must be a pandas DataFrame!")


if __name__ == "__main__":
    # input_path = input("请输入行程单文件地址：")
    input_base_path = "/Users/admin/Downloads/"
    # 修改为行程报销单具体文件名字
    file_name = "滴滴出行行程报销单_lyx_11.pdf"
    input_path = input_base_path + file_name
    df = extract_itinerary(input_path)
    out_df = transToTemplate(df)
    timeMonth = time.strftime("%Y-%m", time.localtime())
    print(out_df)
    file_name = input_path.split('/')[-1].split('.')[0] + '_' + timeMonth + '.xlsx'
    # out_df.to_excel(file_name, index=False)
    output_path = "/Users/admin/Downloads/" + file_name
    out_df.to_excel(output_path, index=False)
    print('\n' * 3)
    # print('xlsx文件存贮在：', os.path.abspath(file_name))
    print('xlsx文件存贮在：', output_path)
