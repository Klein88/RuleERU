//
//  ProductRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/14.
//

import Foundation
import Moya



enum ProductRequestAPI
{
    case pageList(pageSize : Int , pageNum : Int)
    case find(ProductID : String)
    case add(productrequestrecord : ProductRequestrecord)
    case update(productrequestrecord : ProductRequestrecord)
    case delete(ProductID : Int)
}



extension ProductRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .pageList:
            return "/Products/pageList"
        case .find:
            return "/Products/find"
        case .add:
            return "/Products/add"
        case .update :
            return "/Products/update"
        case .delete:
            return "/Products/delete"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
            
        case .pageList:
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
            
        case .pageList(pageSize: let pageSize, pageNum: let pageNum):
            return .requestParameters(parameters: ["pageSize" : pageSize , "pageNum" : pageNum], encoding: URLEncoding.default)
        case .find(ProductID: let ProductID):
            return .requestParameters(parameters: ["ProductID" : ProductID], encoding: URLEncoding.default)
        case .add(productrequestrecord: let productrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(productrequestrecord)
                return .requestData(jsondata)
                
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .update(productrequestrecord: let productrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(productrequestrecord)
                return .requestData(jsondata)
                
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .delete(ProductID: let ProductID):
            return .requestParameters(parameters: ["ProductID" : ProductID], encoding: URLEncoding.default)
        }
    }
    
    var headers: [String : String]? {
        return ["Content-type" : "application/json"]
    }
    
    
    
}
