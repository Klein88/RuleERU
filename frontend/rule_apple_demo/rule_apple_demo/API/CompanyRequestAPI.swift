//
//  CompanyRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/14.
//

import Foundation
import Moya

enum CompanyAPI
{
    case pageList(pageSize : Int , pageNum : Int)
    case find(CompanyID : String)
    case add(companyid : Int , userid : Int , companyname : String , companyaddress : String)
    case update(companyid : Int , userid : Int , companyname : String , companyaddress : String)
    case delete(companyid : Int)
}

extension CompanyAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
        case .pageList:
            return "/Companies/pageList"
        case .find:
            return "/Companies/find"
        case .add :
            return "/Companies/add"
        case .update :
            return "/Companies/update"
        case .delete:
            return "/Companies/delete"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
        case.pageList :
            return .get
        case .find :
            return .get
        case .add :
            return .post
        case .update :
            return .post
        case .delete:
            return .delete
        }
    }
    
    var task: Moya.Task {
        switch self
        {
        case.pageList(pageSize: let pagesize, pageNum: let pagenum):
            return .requestParameters(parameters: ["pageSize" : pagesize , "pageNum" : pagenum], encoding: URLEncoding.default)
        case .find(CompanyID: let companyid):
            return .requestParameters(parameters: ["CompanyID" : companyid], encoding: URLEncoding.default)
        case .add(companyid: let companyid, userid: let userid, companyname: let companyname, companyaddress: let companyaddress):
            do
            {
                let company = Company(companyid: companyid, userid: userid, companyname: companyname, companyaddress: companyaddress)
                let jsondata = try JSONEncoder().encode(company)
                return .requestData(jsondata)
                
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .update(companyid: let companyid, userid: let userid, companyname: let companyname, companyaddress: let companyaddress):
            do
            {
                let company = Company(companyid: companyid, userid: userid, companyname: companyname, companyaddress: companyaddress)
                let jsondata = try JSONEncoder().encode(company)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
           
        case .delete(companyid: let companyid):
            return .requestParameters(parameters: ["CompanyID" : companyid], encoding: URLEncoding.default)
        }
    }
    
    var headers: [String : String]? {
        return ["Content-type" : "application/json"]
    }
}
