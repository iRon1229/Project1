import requests
from  openpyxl import Workbook
import json
import sys
wb= Workbook()
ws = wb.active
headers = {
    "Accept": "application/json, text/javascript, */*; q=0.01",
    "Cookie": "_ga=GA1.3.2058066244.1624336601; _gid=GA1.3.328485635.1624336601; _ga_9CE1X6J1FG=GS1.1.1624336583.4.1.1624336613.24; ins-c=undefined; ins-storage-version=2; _fbp=fb.2.1624336601204.264399395; ECWEBSESS=6dd40d1fc3.cf814906b9612b68261ac70aaa3f7c479bbbacc4.1624336600; vensession=59d7c41c-ab5a-4355-9ac1-e70c412eff24.wgc-1w1g20210622.se; _gat_UA-115564493-1=1; ECC=43b234420fb284fa6d80de14fcbc22c54095dd06.1624336601; U=7c7645c5baf401de78f2b44cc1b2ac8aea7460b0; _gcl_au=1.1.1174425380.1624336601; venguid=00abe1fe-34cf-4946-abc7-2394413ce51f.wgc-1w1g20210622",
    "Accept-Language": "zh-tw",
    "Host": "ecshweb.pchome.com.tw",
    "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1 Safari/605.1.15",
    "Referer": "https://ecshweb.pchome.com.tw/search/v3.3/?q=apple",
    "Accept-Encoding": "gzip, deflate, br",
    "Connection": "keep-alive",
    "X-Requested-With": "XMLHttpRequest"
}
session = requests.session()

for i in range(1, int(sys.argv[2])+1):
    try:
        print(i)
        res = session.get(
            f"https://ecshweb.pchome.com.tw/search/v3.3/all/results?q={sys.argv[1]}&page={i}&sort=sale/dc", headers=headers)
        datas = json.loads(res.text)["prods"]
        for data in datas:
            ws.append([data["picS"], data["name"], data["describe"],
                data["price"], data["originPrice"]])
        # print(dir(ws))
    except Exception as e:
        print("err",i,e)
wb.save(filename='tmp.xlsx')

