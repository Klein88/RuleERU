//
//  DocumentUpView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/17.
//

import SwiftUI
import Moya
struct DocumentUpView: View {
    @Binding var uiimage : UIImage
    @State var isshowfullscreencoverview : Bool = false
    @State var imagename : String
    @State var isshowselfuiimage : Bool = false
    @State var isshowExampleuiimage : Bool = false
    @State var uploadname : String
    @Binding var isupload : Bool
    var body: some View {
        HStack{
            VStack
            {
                
                Image(uiImage: self.uiimage)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                Button(action: {
                    self.isshowfullscreencoverview = true
                }, label: {
                    Image(systemName: "plus")
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 30)
                })
                Text("点击上传")
                    .font(.system(size: 30))
                    .foregroundStyle(.blue)
                    .fontWeight(.heavy)
            }
            .frame(width: UIScreen.main.bounds.width / 2 - 10 , height: UIScreen.main.bounds.width / 2 - 10)
            .border(.blue , width: 5)
            .padding(.leading , 5)
            
            VStack
            {
                Image("\(imagename)")
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: UIScreen.main.bounds.width / 2 - 30 , height: UIScreen.main.bounds.width / 2 - 50)
                    .onTapGesture {
                        self.isshowExampleuiimage = true
                    }
                Text("示例")
            }
            .frame(width: UIScreen.main.bounds.width / 2 - 10 , height: UIScreen.main.bounds.width / 2 - 10)
            .border(.blue , width: 5)
            .padding(.leading , 5)
            .padding(.trailing , 5)
        }
        .fullScreenCover(isPresented: $isshowfullscreencoverview){
            ImagePickerView(sourceType: .photoLibrary) { uiimage_photoL in
                self.uiimage = uiimage_photoL
            }
        }
        .fullScreenCover(isPresented: $isshowExampleuiimage){
            
            ShowExampleImage(isshowExampleUIImage: $isshowExampleuiimage, imagename: self.imagename)
            
        }
        
       
    }
}


struct ShowExampleImage : View
{
    @Binding var isshowExampleUIImage : Bool
    @State var imagename : String
    var body: some View{
        VStack
        {
          Image(imagename)
                .resizable()
                .aspectRatio(contentMode: .fit)
                .frame(width: UIScreen.main.bounds.width - 20  , height: UIScreen.main.bounds.height - 20)
        }
        .overlay(alignment: .topLeading) {
            Button(action: {
                self.isshowExampleUIImage = false
            }, label: {
                Image(systemName: "x.circle.fill")
            })
            .padding(.top , 30)
            .padding(.leading , 30)
        }
    }
}



#Preview {
    DocumentUpView(uiimage: .constant(UIImage()), imagename: "Legal_example_签字", uploadname: "1111", isupload: .constant(false))
}
