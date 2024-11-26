//
//  TodoRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/14.
//

import Foundation
import Moya

enum TodoRequestAPI
{
    case pageList(pageSize : Int , pageNum : Int)
    case find(ToDoID : String)
    case add(todoeequestrecord : TodoRequestrecord)
    case update(todoeequestrecord : TodoRequestrecord)
    case delete(ToDoID : Int)
}


extension TodoRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .pageList :
            return "/Todos/pageList"
        case .find :
            return "/Todos/find"
        case .add :
            return "/Todos/add"
        case .update :
            return "/Todos/update"
        case .delete :
            return "/Todos/delete"
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
        case .find(ToDoID: let ToDoID):
            return .requestParameters(parameters: ["ToDoID" : ToDoID], encoding: URLEncoding.default)
        case .add(todoeequestrecord: let todoeequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(todoeequestrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .update(todoeequestrecord: let todoeequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(todoeequestrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .delete(ToDoID: let ToDoID):
            return .requestParameters(parameters: ["ToDoID" : ToDoID], encoding: URLEncoding.default)
        }
    }
    
    
    var headers: [String : String]? {
        return  ["Content-type" : "application/json"]
    }
    
    
}
