//
//  PackagingSummaryDeclarationRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/23.
//

import SwiftUI
import Moya

enum PackagingSummaryDeclarationRequestAPI
{
    case find(pageSize : Int , pageNum : Int)
    case add( packagingsummarydeclarationrequestrecord : PackagingSummaryDeclarationRequestrecord)
    case findById(declarationid : Int)
    case update( packagingsummarydeclarationrequestrecord : PackagingSummaryDeclarationRequestrecord)
    case delete(declarationid : Int)
}


extension PackagingSummaryDeclarationRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .find:
            return "/Packagingsummarydeclaration/pageList"
        case .add:
            return "/Packagingsummarydeclaration/add"
        case .findById:
            return "/Packagingsummarydeclaration/find"
        case .update:
            return "/Packagingsummarydeclaration/update"
        case .delete(declarationid: let declarationid):
            return "/Packagingsummarydeclaration/delete/\(declarationid)"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
            
        case .find:
            return .get
        case .add:
            return .post
        case .findById:
            return .get
        case .update:
            return .post
        case .delete :
            return .delete
        }
    }
    
    var task: Moya.Task {
        switch self
        {
            
        case .find(pageSize: let pageSize, pageNum: let pageNum):
            return .requestParameters(parameters: ["pageSize" : pageSize , "pageNum" : pageNum], encoding: URLEncoding.default)
        case .add(packagingsummarydeclarationrequestrecord: let packagingsummarydeclarationrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(packagingsummarydeclarationrequestrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .findById(declarationid: let declarationid):
            return .requestParameters(parameters: ["declarationid" : declarationid], encoding: URLEncoding.default)
        case .update(packagingsummarydeclarationrequestrecord: let packagingsummarydeclarationrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(packagingsummarydeclarationrequestrecord)
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
