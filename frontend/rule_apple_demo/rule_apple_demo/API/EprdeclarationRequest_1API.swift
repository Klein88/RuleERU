//
//  Eprdeclaration1RequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/29.
//

import Foundation
import Moya


enum EprdeclarationRequest_1API
{
    case pageList(pageSize : Int , pageNum : Int)
    case find(declarationid : Int)
    case add(eprdeclarationrequest_1record : EprdeclarationRequest_1record)
    case update(eprdeclarationrequest_1record : EprdeclarationRequest_1record)
    case delete(declarationid : Int)
}
extension EprdeclarationRequest_1API : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .pageList :
            return "/Eprdeclaration1/pageList"
        case .find :
            return "/Eprdeclaration1/find"
        case .add :
            return "/Eprdeclaration1/add"
        case .update :
            return "/Eprdeclaration1/update"
        case .delete(declarationid: let id) :
            return "/Eprdeclaration1/delete/\(id)"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
            
        case .pageList :
            return .get
            
        case .find :
            return .get
        case .add :
            return .post
        case .update :
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
        case .find(declarationid: let declarationid):
            return .requestParameters(parameters: ["declarationid" : declarationid], encoding: URLEncoding.default)
        case .add(eprdeclarationrequest_1record: let eprdeclarationrequest_1record):
            do
            {
                let jsondata = try JSONEncoder().encode(eprdeclarationrequest_1record)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .update(eprdeclarationrequest_1record: let eprdeclarationrequest_1record):
            do
            {
                let jsondata = try JSONEncoder().encode(eprdeclarationrequest_1record)
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
