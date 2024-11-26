//
//  ImportByYuancailiaoAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/17.
//

import Foundation
import Moya

enum ImportByYuancailiaoAPI
{
    case pageList(pageSize : Int , pageNum : Int)
}

extension ImportByYuancailiaoAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
           
        case .pageList :
            return "/Importbyyuancailiao/pageList"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
           
        case .pageList :
            return .get
        }
    }
    
    var task: Moya.Task {
        switch self
        {
           
        case .pageList(pageSize: let pageSize, pageNum: let pageNum):
            return .requestParameters(parameters: ["pageSize" : pageSize , "pageNum" : pageNum], encoding: URLEncoding.default)
        }
    }
    
    var headers: [String : String]? {
        return ["Content-type" : "application/json"]
    }
    
    
    
    
    
}
