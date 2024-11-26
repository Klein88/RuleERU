//
//  ComplianceapplicationRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/6.
//

import Foundation
import Moya



enum ComplianceapplicationRequestAPI
{
    case pageList(pageSize : Int , pageNum : Int)
    case findById(applicationid : Int)
    case add(complianceapplicationrequestrecord : ComplianceapplicationRequestrecord)
    case delete(applicationid : Int)
}

extension ComplianceapplicationRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .pageList :
            return "/Complianceapplication/pageList"
        case .findById :
            return "/Complianceapplication/find"
        case .add :
            return "/Complianceapplication/add"
        case .delete(applicationid: let applicationid):
            return "/Complianceapplication/delete/\(applicationid)"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
        case .pageList :
            return .get
        case .findById :
            return .get
        case .add :
            return .post
        case .delete :
            return .delete
        }
    }
    
    var task: Moya.Task {
        switch self
        {
        case .pageList(pageSize: let pageSize, pageNum: let pageNum):
            return .requestParameters(parameters: ["pageSize" : pageSize , "pageNum" : pageNum], encoding: URLEncoding.default)
        case .findById(applicationid: let applicationid):
            return .requestParameters(parameters: ["applicationid" : applicationid], encoding: URLEncoding.default)
        case .add(complianceapplicationrequestrecord: let complianceapplicationrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(complianceapplicationrequestrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .delete :
            return .requestPlain
        }
    }
    
    var headers: [String : String]? {
        return ["Content-type" : "application/json"]
    }
    
    
    
    
}
