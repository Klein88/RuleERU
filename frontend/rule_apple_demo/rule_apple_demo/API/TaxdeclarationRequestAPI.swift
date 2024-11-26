//
//  TaxdeclarationRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/15.
//

import Foundation
import Moya


enum TaxdeclarationRequestAPI
{
    case find(DeclarationID : String)
    case pageList(pageSize : Int , pageNum : Int)
    case add(taxdeclarationtequestrecord : TaxdeclarationRequestrecord)
    case delete(DeclarationID : Int)
    case findByVATNumber(searchbyvatnumber : String)
}

extension TaxdeclarationRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .find:
            return  "/Taxdeclaration/find"
        case .pageList:
            return  "/Taxdeclaration/pageList"
        case .add:
            return "/Taxdeclaration/add"
        case .delete:
            return "/Taxdeclaration/delete"
        case .findByVATNumber:
            return "/Taxdeclaration/find1"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
            
        case .find:
            return .get
        case .pageList:
            return .get
        case .add :
            return .post
        case .delete:
            return .delete
        case .findByVATNumber :
            return .get
        }
    }
    
    var task: Moya.Task {
        switch self
        {
            
        case .find(DeclarationID: let DeclarationID):
            return .requestParameters(parameters: ["DeclarationID" : DeclarationID], encoding: URLEncoding.default)
        case .pageList(pageSize: let pageSize, pageNum: let pageNum):
            return .requestParameters(parameters: ["pageSize" : pageSize , "pageNum" : pageNum], encoding: URLEncoding.default)
        case .add(taxdeclarationtequestrecord: let taxdeclarationtequestrecord):
            do
            {
                print(taxdeclarationtequestrecord)
                let jsondata = try JSONEncoder().encode(taxdeclarationtequestrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .delete(DeclarationID: let DeclarationID):
            return .requestParameters(parameters: ["DeclarationID" : DeclarationID], encoding: URLEncoding.default
            )
        case .findByVATNumber(searchbyvatnumber: let searchbyvatnumber):
            return .requestParameters(parameters: ["searchbyvatnumber" : searchbyvatnumber], encoding: URLEncoding.default)
        }
    }
    
    var headers: [String : String]? {
        return ["Content-type" : "application/json" ]
    }
    
    
    
    
    
}
