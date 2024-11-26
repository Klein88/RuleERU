//
//  CompanyinfoRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/14.
//

import Foundation
import Moya
enum CompanyinfoRequestAPI
{
    case pageList(pagesize : Int , pagenum : Int)
    case find(CompanyName : String)
    case update(companyinforecord  : Companyinforecord)
}

extension CompanyinfoRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
        case .find :
            return "/Companyinfo/find"
        case .pageList :
            return "/Companyinfo/pageList"
        case .update :
            return "/Companyinfo/update"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
        case .find :
            return .get
        case .pageList :
            return .get
        case .update :
            return .post
        }
    }
    
    var task: Moya.Task {
        switch self
        {
        case.find(CompanyName: let companyname):
            return .requestParameters(parameters: ["companyname" : companyname], encoding: URLEncoding.default)
        case .pageList(pagesize: let pagesize, pagenum: let pagenum):
            return .requestParameters(parameters: ["pageSize" : pagesize , "pageNum" : pagenum], encoding: URLEncoding.default)
        case .update(companyinforecord: let companyinforecord):
            do
            {
                let jsondata = try JSONEncoder().encode(companyinforecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        }
    }
    
    var headers: [String : String]? {
        return ["Content-type" : "application/json"]
    }
    
    
}
