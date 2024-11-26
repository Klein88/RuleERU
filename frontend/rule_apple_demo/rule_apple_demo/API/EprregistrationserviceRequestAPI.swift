//
//  EprregistrationserviceRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/23.
//

import Foundation
import Moya




enum EprregistrationserviceRequestAPI
{
    case add(eprregistrationservicerequestrecord : EprregistrationserviceRequestrecord)
}


extension EprregistrationserviceRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .add :
            return "/Eprregistrationservicedata/add"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
            
        case .add :
            return .post
        }
    }
    
    var task: Moya.Task {
        switch self
        {
            
        case .add(eprregistrationservicerequestrecord: let eprregistrationservicerequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(eprregistrationservicerequestrecord)
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
