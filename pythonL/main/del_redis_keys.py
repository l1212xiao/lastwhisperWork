import redis

r = redis.Redis(host="10.136.130.39", port=9999, db=0, decode_responses=True)
list_keys = r.keys("HAWK*")

for key in list_keys:
    print(key)
    r.delete(key)
