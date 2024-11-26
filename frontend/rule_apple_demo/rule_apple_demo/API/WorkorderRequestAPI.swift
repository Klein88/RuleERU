//
//  WorkorderRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/14.
//

import Foundation
import Moya


enum WorkorderRequestAPI
{
    case pageList(pageSize : Int , pageNum : Int)
    case find(WorkorderID : String)
    case add(workorderrequestrecord  : WorkorderRequestrecord)
    
}

extension WorkorderRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .pageList :
            return "/Workorder/pageList"
        case .find :
            return "/Workorder/find"
        case .add :
            return "/Workorder/add"
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
        }
    }
    
    var task: Moya.Task {
        switch self
        {
            
        case .pageList(pageSize: let pageSize, pageNum: let pageNum):
            return .requestParameters(parameters: ["pageSize" : pageSize , "pageNum" : pageNum], encoding: URLEncoding.default)
        case .find(WorkorderID: let WorkorderID):
            return .requestParameters(parameters: ["WorkorderID" : WorkorderID], encoding: URLEncoding.default)
        case .add(workorderrequestrecord: let workorderrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(workorderrequestrecord)
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
