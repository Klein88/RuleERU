//
//  VatdeclarationdetailsRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/15.
//

import Foundation
import Moya

enum VatdeclarationdetailsRequestAPI
{
    case find(DeclarationDetailID : String)
    case pageList(pageSize : Int , pageNum : Int)
    case add(vatdeclarationdetailsrequestrecord : VatdeclarationdetailsRequestrecord)
    case delete(DeclarationDetailID : Int)
}

extension VatdeclarationdetailsRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .find :
            return "/Vatdeclarationdetails/find"
        case .pageList :
            return "/Vatdeclarationdetails/pageList"
        case .add :
            return "/Vatdeclarationdetails/add"
        case .delete :
            return "/Vatdeclarationdetails/delete"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
        case .find :
            return .get
        case .pageList :
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
        case .find(DeclarationDetailID: let DeclarationDetailID):
            return .requestParameters(parameters: ["DeclarationDetailID" : DeclarationDetailID], encoding: URLEncoding.default)
        case .pageList(pageSize: let pageSize, pageNum: let pageNum):
            return .requestParameters(parameters: ["pageSize" : pageSize , "pageNum" : pageNum], encoding: URLEncoding.default)
        case .add(vatdeclarationdetailsrequestrecord: let vatdeclarationdetailsrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(vatdeclarationdetailsrequestrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .delete(DeclarationDetailID: let DeclarationDetailID):
            return .requestParameters(parameters: ["DeclarationDetailID" : DeclarationDetailID], encoding: URLEncoding.default)
        }
    }
    
    var headers: [String : String]? {
        return ["Content-type" : "application/json"]
    }
    
    
}
