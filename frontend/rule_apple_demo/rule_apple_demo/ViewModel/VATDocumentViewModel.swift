//
//  VATDocumentViewModel.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/13.
//

import Foundation
import UIKit



class VATDocumentViewModel : ObservableObject
{
    @Published var VATTaxZhengshu : UIImage = UIImage()
    @Published var VATDeclaration1 : UIImage = UIImage()
    @Published var VATDeclaration2 : UIImage = UIImage()
    @Published var VATDeclaration3 : UIImage = UIImage()
    @Published var ZhaunDailiChangNuoShu : UIImage = UIImage()
    @Published var GongsiYingYeZhiZao : UIImage = UIImage()
    @Published var Legal_example_front : UIImage = UIImage()
    @Published var Legal_example_back : UIImage = UIImage()
    @Published var Legal_example_签字 : UIImage = UIImage()
    
    @Published var TaxService : TaxServiceRequestrecord = TaxServiceRequestrecord()
    
    
}
