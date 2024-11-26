//
//  EprserviceRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/29.
//

import Foundation
import Moya


enum EprserviceRequestAPI
{
    case pageList(pageSize : Int , pageNum : Int)
    case find(eprserviceid : Int)
    case add(eprservicerequestrecord : EprserviceRequestrecord)
    case update(eprservicerequestrecord : EprserviceRequestrecord)
}

extension EprserviceRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .pageList :
            return "/Eprservice/pageList"
        case .find :
            return "/Eprservice/find"
        case .add :
            return "/Eprservice/add"
        case .update :
            return "/Eprservice/update"
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
        }
    }
    
    var task: Moya.Task {
        switch self
        {
            
        case .pageList(pageSize: let pageSize, pageNum: let pageNum):
            return .requestParameters(parameters: ["pageSize" : pageSize , "pageNum" : pageNum], encoding: URLEncoding.default)
        case .find(eprserviceid: let eprserviceid):
            return .requestParameters(parameters: ["eprserviceid" : eprserviceid], encoding: URLEncoding.default)
        case .add(eprservicerequestrecord: let eprservicerequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(eprservicerequestrecord)
                return .requestData(jsondata)
            }catch let error{
                print(error)
                return .requestPlain
            }
        case .update(eprservicerequestrecord: let eprservicerequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(eprservicerequestrecord)
                return .requestData(jsondata)
            }catch let error{
                print(error)
                return .requestPlain
            }
        }
    }
    
    var headers: [String : String]? {
        return ["Content-type" : "application/json"]
    }
    
    
}
