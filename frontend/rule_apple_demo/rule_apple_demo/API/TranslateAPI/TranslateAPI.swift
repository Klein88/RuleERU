//
//  TranslateAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/31.
//

import Foundation
import Moya
import CommonCrypto

extension String {
    //MARK: -MD5加密
    public func addMD5() -> String {
        let str = self.cString(using: .utf8)
        let strLen = CUnsignedInt(self.lengthOfBytes(using: .utf8))
        let digestLen = Int(CC_MD5_DIGEST_LENGTH)
        let result = UnsafeMutablePointer<CUnsignedChar>.allocate(capacity:digestLen)
        CC_MD5(str!, strLen, result)
            
        let hash = NSMutableString()
        for i in 0 ..< digestLen {
            hash.appendFormat("%02X", result[i])
        }
        free(result)
        return String(format: hash as String)
    }
}


enum TranslateAPI
{
    case translate(query : String , from : String , to : String)
}

extension  TranslateAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "https://fanyi-api.baidu.com/api/trans/vip/translate?")!
    }
    
    var path: String {
        switch self
        {
            
        case .translate :
            return ""
        }
    }
    
    var method: Moya.Method {
        switch self
        {
            
        case .translate :
            return .post
        }
    }
    
    var task: Moya.Task {
        switch self
        {
            case .translate(query: let query, from: let from, to: let to) :
            do
            {
                 var StringToMD5 = "20231031001864736" + query + "1435660288" + "QHT3VcHoAAmeiVhDXV2L"
                StringToMD5 = StringToMD5.addMD5().lowercased()
                print(StringToMD5)
                return .requestParameters(parameters: ["q" : query , "from" : from , "to" : to , "appid" : "20231031001864736" , "salt" : "1435660288" , "sign" : StringToMD5], encoding: URLEncoding.default)
             
            }catch let error{
                return .requestPlain
            }
        }
    }
    
    var headers: [String : String]? {
        return ["Content-type" : "application/x-www-form-urlencoded"]
    }
    
    
}



//master
struct TranslateRequest : Codable , Hashable
{
    var from : String!
    var to : String!
    var trans_result : [trans_resultData]!
    var error_code : String!
    
}

struct trans_resultData : Codable , Hashable
{
    var src : String!
    var dst : String!
}
