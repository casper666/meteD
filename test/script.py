import requests
import csv
import time
ts = long(time.time())
with open('data.csv') as csvfile:
    reader = csv.DictReader(csvfile)
    for row in reader:
        print(row['lat'], row['lng'])
        r = requests.post("https://data-infinity-128221.appspot.com/add.do", data = {
        'longitude': row['lng'],
        'latitude': row['lat'],
        'streetName': 'a',
        'dailyFreeParkingStartTime': '146021547',
        'dailyFreeParkingEndTime': '146021547',
        'hourlyFee': '23',
        'freeDays': '3',
        'isOccupied': 'true',
        'occupiedStartTime': '146021547',
        'occupiedEndTime': ts + long(row['ocptime'])})
        print(r.status_code, r.reason)
