//
//  ExampleJSON.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/14.
//

import Foundation



let CompanyByIdJSONData = """
{
    "code": 20000,
    "data": {
        "companyid": 2,
        "userid": 2,
        "companyname": "示例公司B",
        "companyaddress": "上海市陆家嘴"
    },
    "message": "ok",
    "description": null
}
""".data(using: .utf8)!


let CompanyJSONData = """
{
    "code": 20000,
    "data": {
        "records": [
            {
                "companyid": 1,
                "userid": 1,
                "companyname": "示例公司A",
                "companyaddress": "北京市中关村"
            },
            {
                "companyid": 2,
                "userid": 2,
                "companyname": "示例公司B",
                "companyaddress": "上海市陆家嘴"
            }
        ],
        "total": 0,
        "size": 1,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "maxLimit": null,
        "countId": null,
        "pages": 0
    },
    "message": "ok",
    "description": null
}



""".data(using: .utf8)!


let CompanyAddData = """

{
    "code": 20000,
    "data": 1,
    "message": "ok",
    "description": null
}

""".data(using: .utf8)!



let CompanyinfoRequestData = """
{
    "code": 20000,
    "data": {
        "records": [
            {
                "userid": 1,
                "companyname": "示例公司A",
                "companytype": "科技",
                "companyaddress": "北京市",
                "companytel": "12345678",
                "companyregister": "北京",
                "companyphoto": "licenseA.jpg",
                "companynumber": "A123456",
                "companystatue": "正常"
            },
            {
                "userid": 2,
                "companyname": "示例公司B",
                "companytype": "贸易",
                "companyaddress": "上海市",
                "companytel": "87654321",
                "companyregister": "上海",
                "companyphoto": "licenseB.jpg",
                "companynumber": "B123456",
                "companystatue": "正常"
            }
        ],
        "total": 0,
        "size": 1,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "maxLimit": null,
        "countId": null,
        "pages": 0
    },
    "message": "ok",
    "description": null
}
""".data(using: .utf8)!



let productRequestData = """
{
    "code": 20000,
    "data": {
        "records": [
            {
                "productid": 1,
                "companyid": 1,
                "productname": "产品A1",
                "productdescription": "这是示例公司A的产品A1",
                "productprice": 100.00,
                "productcategory": "电子产品",
                "productorigin": "中国",
                "manufacturedate": "2022-12-31T16:00:00.000+00:00",
                "expirydate": "2024-12-31T16:00:00.000+00:00"
            },
            {
                "productid": 2,
                "companyid": 2,
                "productname": "产品B1",
                "productdescription": "这是示例公司B的产品B1",
                "productprice": 200.00,
                "productcategory": "家居用品",
                "productorigin": "中国",
                "manufacturedate": "2023-04-30T16:00:00.000+00:00",
                "expirydate": "2024-04-30T16:00:00.000+00:00"
            }
        ],
        "total": 0,
        "size": 1,
        "current": 2,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "maxLimit": null,
        "countId": null,
        "pages": 0
    },
    "message": "ok",
    "description": null
}
""".data(using: .utf8)!



//MARK: ------   开摆，不搞模拟数据了
