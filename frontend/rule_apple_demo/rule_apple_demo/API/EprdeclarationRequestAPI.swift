//
//  EprdeclarationRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/24.
//

import Foundation
import Moya


enum EprdeclarationRequestAPI
{
    case pageList(pageSize : Int , pageNum : Int)
    case findById(declarationid : Int)
    case add(eprdeclarationrequestrecord : EprdeclarationRequestrecord)
    case upload(eprdeclarationrequestrecord : EprdeclarationRequestrecord)
    case delete(declarationid : Int)
}

extension EprdeclarationRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self{
            
        case .pageList :
            return "/Eprdeclaration/pageList"
        case .findById :
            return "/Eprdeclaration/find"
        case .add :
            return "/Eprdeclaration/add"
        case .upload :
            return "/Eprdeclaration/update"
        case .delete(declarationid: let id) :
            return "/Eprdeclaration/delete/\(id)"
        }
    }
    
    var method: Moya.Method {
        switch self {
        case .pageList :
            return .get
        case .findById :
            return .get
        case .add :
            return .post
        case .upload :
            return .post
        case .delete :
            return .delete
        }
    }
    
    var task: Moya.Task {
        switch self{
            
        case .pageList(pageSize: let pageSize, pageNum: let pageNum):
            return .requestParameters(parameters: ["pageSize" : pageSize , "pageNum" : pageNum], encoding: URLEncoding.default)
        case .findById(declarationid: let declarationid):
            return .requestParameters(parameters: ["declarationid" : declarationid], encoding: URLEncoding.default)
        case .add(eprdeclarationrequestrecord: let eprdeclarationrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(eprdeclarationrequestrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .upload(eprdeclarationrequestrecord: let eprdeclarationrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(eprdeclarationrequestrecord)
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
