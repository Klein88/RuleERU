//
//  FileUpload.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/23.
//

import Foundation
import Moya

enum FileUploadAPI{
    case upload(data : Data , fileName : String)
    case download(imagename : String)
    
    
}









//this is a demo for upload
extension FileUploadAPI : TargetType
{
    var baseURL: URL {
        return URL(string: "http://121.40.119.233:8081")!
    }
    
    var path: String {
        switch self
        {
            
        case .upload(data: let data, fileName: let filename):
            return "/api/upload/sales-data/\(filename)"
        case .download(imagename: let imagename):
            return "/api/download/images/\(imagename)"
        }
    }
    
    var method: Moya.Method {
        switch self
        {
        case .upload:
            return .post
        case .download:
            return .get
        }
    }
    
    var task: Moya.Task {
        switch self
        {
            
            
            
        case .upload(data: let data, fileName: let fileName):
            let formData = MultipartFormData(provider: .data(data), name: "file" , fileName: fileName ,mimeType: "multipart/form-data")
            return .uploadMultipart([formData])
            
        case .download:
            return .requestPlain
        }
    }
    
    var headers: [String : String]? {
        return ["Content-type" : "application/json"]
    }
    
    
}



func FileUpload(){
    
    
    
    
}
