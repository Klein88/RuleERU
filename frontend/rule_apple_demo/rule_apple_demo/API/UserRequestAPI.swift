//
//  UserRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/15.
//

import Foundation
import Moya

enum UserRequestAPI
{
    case login(username : String , password : String)
    case register(userrequestrecord : UserRequestrecord)
}
extension UserRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .login :
            return "/user/login"
        case .register :
            return "/user/register"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
        case .login :
            return .post
        case .register :
            return .post
        }
    }
    
    var task: Moya.Task {
        switch self
        {
        case .login(username: let username, password: let password):
            do
            {
                let jsondata = try JSONEncoder().encode(Users(username:  username , password:  password))
                return .requestData(jsondata)
            }catch let error{
                print(error)
                return .requestPlain
            }
        case .register(userrequestrecord: let userrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(userrequestrecord)
                return .requestData(jsondata)
            }
            catch let error
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
