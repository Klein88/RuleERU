//
//  LocaltaxpolicyRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/15.
//

import Foundation
import Moya


enum LocaltaxpolicyRequestAPI
{
    case pageList(pageSize : Int , pageNum : Int)
    case find(TaxPolicyDescription : String)
}


extension LocaltaxpolicyRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
        case .pageList :
            return "/Localtaxpolicy/pageList"
        case .find :
            return "/Localtaxpolicy/find"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
            
        case .pageList :
            return .get
        case .find :
            return .get
        }
    }
    
    var task: Moya.Task {
        switch self
        {
        case .find(TaxPolicyDescription: let tax):
            return .requestParameters(parameters: ["TaxPolicyDescription" : tax], encoding: URLEncoding.default)
        case .pageList(pageSize: let pageSize, pageNum: let pageNum):
            return .requestParameters(parameters: ["pageSize" : pageSize , "pageNum" : pageNum], encoding: URLEncoding.default)
        }
    }
    
    var headers: [String : String]? {
        return ["Content-type" : "application/json"]
    }
}
