//
//  EprregistrationRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/23.
//

import Foundation
import Moya


enum EprregistrationRequestAPI
{
    case pageList(pageSize : Int , pageNum : Int)
    case findById(registrationid : Int)
    case add(eprregistrationrequestrecord : EprregistrationRequestrecord)
    case upload(eprregistrationrequestrecord : EprregistrationRequestrecord)
    case delete(registrationid : Int)
}


extension EprregistrationRequestAPI : TargetType{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .pageList :
            return "/Eprregistration/pageList"
        case .findById :
            return "/Eprregistration/find"
        case .add :
            return "/Eprregistration/add"
        case .upload :
            return "/Eprregistration/update"
        case .delete(registrationid: let id) :
            return "/Eprregistration/delete/\(id)"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
            
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
        switch self
        {
            
        case .pageList(pageSize: let pageSize, pageNum: let pageNum):
            return .requestParameters(parameters: ["pageSize" : pageSize , "pageNum" : pageNum], encoding: URLEncoding.default)
        case .findById(registrationid: let registrationid):
            return .requestParameters(parameters: ["registrationid" : registrationid], encoding: URLEncoding.default)
        case .add(eprregistrationrequestrecord: let eprregistrationrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(eprregistrationrequestrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .upload(eprregistrationrequestrecord: let eprregistrationrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(eprregistrationrequestrecord)
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
