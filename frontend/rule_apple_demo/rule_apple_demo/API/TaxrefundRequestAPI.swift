//
//  TaxrefundRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/31.
//

import Foundation
import Moya


enum TaxrefundRequestAPI
{
    case pageList(pageSize : Int , pageNum : Int)
    case update(taxrefundrequestrecord : TaxrefundRequestrecord)
    case add(taxrefundrequestrecord : TaxrefundRequestrecord)
    case findById(taxrefundid : Int)
    case findByCompanyname(companyname : String)
    case findByVatnumber(vatnumber : String)
    case findByOperation(operation : Int)
    case delete(taxrefundid : Int)
}

extension TaxrefundRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .pageList :
            return "/Taxrefund/pageList"
        case .update :
            return "/Taxrefund/update"
        case .add :
            return "/Taxrefund/add"
        case .findById :
            return "/Taxrefund/findbyid"
        case .findByCompanyname :
            return "/Taxrefund/findbycompanyname"
        case .findByVatnumber :
            return "/Taxrefund/findbyvatnumber"
        case .findByOperation(operation: let operation):
            return "/Taxrefund/findbystatus"
        case .delete(taxrefundid: let taxrefundid):
            return "/Taxrefund/delete/\(taxrefundid)"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
            
        case .pageList :
            return .get
        case .update :
            return .post
        case .add :
            return .post
        case .findById :
            return .get
        case .findByCompanyname :
            return .get
        case .findByVatnumber :
            return .get
        case .findByOperation :
            return .get
        case .delete :
            return .delete
        }
    }
    
    var task: Moya.Task {
        switch self
        {
            
        case .pageList(pageSize: let pageSize, pageNum: let pageNum):
            return .requestParameters(parameters: ["pageSize" : 1 , "pageNum" : 1], encoding: URLEncoding.default)
        case .update(taxrefundrequestrecord: let taxrefundrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(taxrefundrequestrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .add(taxrefundrequestrecord: let taxrefundrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(taxrefundrequestrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .findById(taxrefundid: let taxrefundid):
            return .requestParameters(parameters: ["taxrefundid" : taxrefundid], encoding: URLEncoding.default)
        case .findByCompanyname(companyname: let companyname):
            return .requestParameters(parameters: ["companyname" : companyname], encoding: URLEncoding.default)
        case .findByVatnumber(vatnumber: let vatnumber):
            return .requestParameters(parameters: ["vatnumber" : vatnumber], encoding: URLEncoding.default)
        case .findByOperation(operation: let operation):
            return .requestParameters(parameters: ["operation" : operation], encoding: URLEncoding.default)
        case .delete(taxrefundid: let taxrefundid):
            return .requestPlain
        }
    }
    
    var headers: [String : String]? {
        return ["Content-type" : "application/json"]
    }
    
    
    
    
}
