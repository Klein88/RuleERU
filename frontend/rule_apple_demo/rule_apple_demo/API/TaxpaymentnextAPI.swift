//
//  Taxpaymentnext.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/29.
//

import Foundation
import Moya



enum TaxpaymentnextAPI
{
    case add(taxpaymentnextrequestrecord : TaxpaymentnextRequestrecord)
    case find(taxpaymentnextid : Int)
}

extension TaxpaymentnextAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .add :
            return "/Taxpaymentnext/add"
        case .find :
            return "/Taxpaymentnext/findbyid"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
            
        case .add :
            return .post
        case .find :
            return .get
        }
    }
    
    var task: Moya.Task {
        switch self
        {
            
        case .add(taxpaymentnextrequestrecord: let taxpaymentnextrequestrecord):
            do
            {
                let jsondata  = try JSONEncoder().encode(taxpaymentnextrequestrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .find(taxpaymentnextid: let taxpaymentnextid):
            return .requestParameters(parameters: ["taxpaymentnextid" : taxpaymentnextid], encoding: URLEncoding.default)
        }
    }
    
    var headers: [String : String]? {
        return ["Content-type" : "application/json"]
    }
    
    
}
