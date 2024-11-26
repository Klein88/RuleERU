//
//  TaxServiceRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/23.
//

import Foundation
import Moya



enum TaxServiceRequestAPI
{
    case pageList(pageSize : Int , pageNum : Int)
    case findById(taxserviceid : Int)
    case add(taxtervicetequestrecord : TaxServiceRequestrecord)
    case update(taxtervicetequestrecord : TaxServiceRequestrecord)
}

extension TaxServiceRequestAPI : TargetType{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .pageList :
            return "/Taxservice/pageList"
        case .findById :
            return "/Taxservice/find"
        case .add :
            return "/Taxservice/add"
        case .update :
            return "/Taxservice/update"
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
        case .update :
            return .post
        }
    }
    
    var task: Moya.Task {
        switch self
        {
            
        case .pageList(pageSize: let pageSize, pageNum: let pageNum):
            return .requestParameters(parameters: ["pageSize" : pageSize , "pageNum" : pageNum], encoding: URLEncoding.default)
        case .findById(taxserviceid: let taxserviceid):
            return .requestParameters(parameters: ["taxserviceid" : taxserviceid], encoding: URLEncoding.default)
        case .add(taxtervicetequestrecord: let taxtervicetequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(taxtervicetequestrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .update(taxtervicetequestrecord: let taxtervicetequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(taxtervicetequestrecord)
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
