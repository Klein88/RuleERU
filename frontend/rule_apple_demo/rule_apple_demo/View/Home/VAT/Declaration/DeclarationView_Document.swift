//
//  DeclarationView_Document.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/13.
//

import SwiftUI
import Moya


struct DeclarationView_Document: View {
    @State var vatnumber : String
    @State var VATDeclarationImage : UIImage = UIImage()
    @State var VATDeclarationImages : [UIImage] = [UIImage() , UIImage() , UIImage()]
    @State var BackImage : UIImage = UIImage()
    @State var FrontImage : UIImage = UIImage()
    @State var SignImage : UIImage = UIImage()
    @State var CompanyImage : UIImage = UIImage()
    @State var paperImage : UIImage = UIImage()
    var body: some View {
       Form
        {
            Section(header: Text("VAT税号证书").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                Image(uiImage: VATDeclarationImage)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: UIScreen.main.bounds.width  / 2)
            }
            
            Section(header: Text("VAT申报1").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                Image(uiImage: VATDeclarationImages[0])
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: UIScreen.main.bounds.width  / 2)
            }
            
            Section(header: Text("VAT申报2").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                Image(uiImage: VATDeclarationImages[1])
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: UIScreen.main.bounds.width  / 2)
            }
            
            Section(header: Text("VAT申报3").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                Image(uiImage: VATDeclarationImages[2])
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: UIScreen.main.bounds.width  / 2)
            }
            Section(header: Text("转代理承诺书").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                Image(uiImage: paperImage)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: UIScreen.main.bounds.width  / 2)
            }
            Section(header: Text("公司营业执照").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                Image(uiImage: CompanyImage)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: UIScreen.main.bounds.width  / 2)
            }
            Section(header: Text("身份证前").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                Image(uiImage: FrontImage)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: UIScreen.main.bounds.width  / 2)
            }
            
            Section(header: Text("身份证后").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                Image(uiImage: BackImage)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: UIScreen.main.bounds.width  / 2)
            }
            Section(header: Text("法人代表签字").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                Image(uiImage: SignImage)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: UIScreen.main.bounds.width  / 2)
            }
            
            
        }
        .onAppear{
            
            let prodiver = MoyaProvider<FileUploadAPI>()
            
            prodiver.request(.download(imagename: "0" + self.vatnumber + "VAT税号证书.jpg")) { result in
                switch result
                {
                case  .success(let req):
                    do
                    {
                        let jsondata = req.data
                        self.VATDeclarationImage = UIImage(data: jsondata)!
                    }catch let error
                    {
                        print(error)
                    }
                    
                case .failure(_):
                    break
                }
            }
            
            prodiver.request(.download(imagename: "0" + self.vatnumber + "VAT申报1.jpg")) { result in
                switch result
                {
                case .success(let req):
                    self.VATDeclarationImages[0] = UIImage(data: req.data)!
                case .failure(_):
                    break
                }
            }
            
            prodiver.request(.download(imagename: "0" + self.vatnumber + "VAT申报2.jpg")) { result in
                switch result
                {
                case .success(let req):
                    self.VATDeclarationImages[1] = UIImage(data: req.data)!
                case .failure(_):
                    break
                }
            }
            
            prodiver.request(.download(imagename: "0" + self.vatnumber + "VAT申报3.jpg")) { result in
                switch result
                {
                case .success(let req):
                    self.VATDeclarationImages[2] = UIImage(data: req.data)!
                case .failure(_):
                    break
                }
            }
            
            prodiver.request(.download(imagename: "0" + self.vatnumber + "转代理承诺书.jpg")) { result in
                switch result
                {
                case .success(let req):
                    self.paperImage = UIImage(data: req.data)!
                case .failure(_):
                    break
                }
            }
            
            prodiver.request(.download(imagename: "0" + self.vatnumber + "法人代表签字.jpg")) { result in
                switch result
                {
                case .success(let req):
                    self.SignImage = UIImage(data: req.data)!
                case .failure(_):
                    break
                }
            }
            
            
            prodiver.request(.download(imagename: "0" + self.vatnumber + "身份证前.jpg")) { result in
                switch result
                {
                case .success(let req):
                    self.FrontImage = UIImage(data: req.data)!
                case .failure(_):
                    break
                }
            }
            prodiver.request(.download(imagename: "0" + self.vatnumber + "身份证后.jpg")) { result in
                switch result
                {
                case .success(let req):
                    self.BackImage = UIImage(data: req.data)!
                case .failure(_):
                    break
                }
            }
            
            prodiver.request(.download(imagename: "0" + self.vatnumber + "公司营业执照.jpg")) { result in
                switch result
                {
                case .success(let req):
                    self.CompanyImage = UIImage(data: req.data)!
                case .failure(_):
                    break
                }
            }
            
        }
    }
}

#Preview {
    DeclarationView_Document(vatnumber: "VAT123456")
}
