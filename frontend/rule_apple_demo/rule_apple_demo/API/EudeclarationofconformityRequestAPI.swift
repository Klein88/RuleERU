//
//  EudeclarationofconformityRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/6.
//

import Foundation
import Moya


enum EudeclarationofconformityRequestAPI
{
    case pageList(pageSize : Int , pageNum : Int)
    case add(eudeclarationofconformityrecord : Eudeclarationofconformityrecord)
    case addAndGenerate(eudeclarationofconformityrecord : Eudeclarationofconformityrecord)
    case update(eudeclarationofconformityrecord : Eudeclarationofconformityrecord)
    case findByApplicationId(applicationid : Int)
    case findById(declarationid : Int)
    case delete(declarationid : Int)
    
}

extension EudeclarationofconformityRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .pageList :
            return "/Eudeclarationofconformity/pageList"
        case .add :
            return "/Eudeclarationofconformity/add"
        case .update :
            return "/Eudeclarationofconformity/update"
        case .findByApplicationId :
            return "/Eudeclarationofconformity/findbyapplicationid"
        case .findById :
            return "/Eudeclarationofconformity/find"
        case .delete(declarationid: let declarationid):
            return "/Eudeclarationofconformity/delete/\(declarationid)"
        case .addAndGenerate :
            return "/Eudeclarationofconformity/addAndGenerate"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
            
        case .pageList :
            return .get
        case .add :
            return .post
        case .update :
            return .post
        case .findByApplicationId :
            return .get
        case .findById :
            return .get
        case .delete :
            return .delete
        case .addAndGenerate :
            return .post
        }
    }
    
    var task: Moya.Task {
        switch self
        {
            
        case .pageList(pageSize: let pageSize, pageNum: let pageNum):
            return .requestParameters(parameters: ["pageSize" : pageSize , "pageNum" : pageNum], encoding: URLEncoding.default)
        case .add(eudeclarationofconformityrecord: let eudeclarationofconformityrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(eudeclarationofconformityrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .update(eudeclarationofconformityrecord: let eudeclarationofconformityrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(eudeclarationofconformityrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .findByApplicationId(applicationid: let applicationid):
            return .requestParameters(parameters: ["applicationid" : applicationid], encoding: URLEncoding.default)
        case .findById(declarationid: let declarationid):
            return .requestParameters(parameters: ["declarationid" : declarationid], encoding: URLEncoding.default)
        case .delete :
            return .requestPlain
        case .addAndGenerate(eudeclarationofconformityrecord: let eudeclarationofconformityrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(eudeclarationofconformityrecord)
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
