//
//  TaxpaymentRequestAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/2.
//

import Foundation
import Moya



enum TaxpaymentRequestAPI
{
    case pageList(pageSize : Int , pageNum : Int)
    case findById(taxpaymentid : Int)
    case findByPaymentstatus(paymentstatus : Int)
    case add(taxpaymentrequestrecord : TaxpaymentRequestrecord)
    case update(taxpaymentrequestrecord : TaxpaymentRequestrecord)
    case findByCompanyname(companyname : String)
}

extension TaxpaymentRequestAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .pageList :
            return "/Taxpayment/pageList"
        case .findById :
            return "/Taxpayment/findbyid"
        case .findByPaymentstatus :
            return "/Taxpayment/findbystatus"
        case .add :
            return "/Taxpayment/add"
        case .update :
            return "/Taxpayment/update"
        case .findByCompanyname :
            return "/Taxpayment/findbycompanyname"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
            
        case .pageList :
            return .get
        case .findById :
            return .get
        case .findByPaymentstatus :
            return .get
        case .add :
            return .post
        case .update :
            return .post
        case .findByCompanyname :
            return .get
        }
    }
    
    var task: Moya.Task {
        switch self
        {
            
        case .pageList(pageSize: let pageSize, pageNum: let pageNum) :
            return .requestParameters(parameters: ["pageSize" : pageSize , "pageNum" : pageNum], encoding: URLEncoding.default)
        case .findById(taxpaymentid: let taxpaymentid):
            return .requestParameters(parameters: ["taxpaymentid" : taxpaymentid], encoding: URLEncoding.default)
        case .findByPaymentstatus(paymentstatus: let paymentstatus):
            return .requestParameters(parameters: ["paymentstatus" : paymentstatus], encoding: URLEncoding.default)
        case .add(taxpaymentrequestrecord: let taxpaymentrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(taxpaymentrequestrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .update(taxpaymentrequestrecord: let taxpaymentrequestrecord):
            do
            {
                let jsondata = try JSONEncoder().encode(taxpaymentrequestrecord)
                return .requestData(jsondata)
            }catch let error
            {
                print(error)
                return .requestPlain
            }
        case .findByCompanyname(companyname: let companyname):
            return .requestParameters(parameters: ["companyname" : companyname], encoding: URLEncoding.default)
        }
    }
    
    var headers: [String : String]? {
        return ["Content-type" : "application/json"]
    }
    
    
    
    
}
