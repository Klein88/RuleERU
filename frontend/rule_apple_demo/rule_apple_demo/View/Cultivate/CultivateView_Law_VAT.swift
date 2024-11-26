//
//  CultivateView_Law_VAT.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/13.
//

import SwiftUI

struct CultivateView_Law_VAT: View {
    var body: some View {
        ScrollView{
            VStack{
                HStack
                {
                    Text("欧盟VAT法规知识")
                        .font(.system(size: 30))
                        .fontWeight(.heavy)
                        .padding(.leading , 20)
                    Spacer()
                }
                ExpandableView(thumbnail: ThumbnailView(content: {
                    VStack(alignment: .leading, spacing: 10)
                    {
                        Text("1.1 增值税的定义及计算公式")
                            .frame(maxWidth: .infinity, alignment: .leading)
                            .foregroundStyle(.white)
                            .font(.custom("ArialRoundedMTBold", size: 20))
                        
                    }
                    .padding()
                }), expanded: ExpandedView(content: {
                    VStack(alignment: .leading, spacing: 12)
                    {
                        Text("1.1 增值税的定义及计算公式")
                            .frame(maxWidth: .infinity, alignment: .leading)
                            .foregroundStyle(.white)
                            .font(.custom("ArialRoundedMTBold", size: 28))
                        Text("Reading time: 3 mins")
                                   .font(.custom("ArialRoundedMTBold", size: 14))
                                   .foregroundStyle(.white)
                        Text("增值税是以商品(含应税劳务)在流转过程中产生的增值额作为计税依据而征收的一种流转税。从计税原理上说，增值税是对商品生产、流通、劳务服务中多个环节的新增价值或商品的附加值征收的一种流转税。对于跨境电商产品而言，通常会遇到的两个环节就是产品进入到其他国家，在清关缴纳关税时需要缴纳进口增值税，最终产品销售之后，需要缴纳销售增值税。进口增值税的计算公式为：（申报货值+FBA头程+关税）x 征税国增值税税率 销售增值税的计算公式为：最终售价 ÷ （1+征税国增值税税率）")
                                    .font(.custom("ArialRoundedMT", size: 14))
                                    .foregroundStyle(.white)
                        Text("进口增值税的计算公式为：（申报货值+FBA头程+关税）x 征税国增值税税率")
                            .font(.custom("ArialRoundedMT", size: 14))
                            .foregroundStyle(.white)
                        Text("销售增值税的计算公式为：最终售价 ÷ （1+征税国增值税税率）")
                            .font(.custom("ArialRoundedMT", size: 14))
                            .foregroundStyle(.white)
                                Spacer()
                    }
                    .padding()
                }))
                
                
                ExpandableView(thumbnail: ThumbnailView(content: {
                    VStack(alignment: .leading, spacing: 10)
                    {
                        Text("1.2 发货国与目的国计税原则")
                            .frame(maxWidth: .infinity, alignment: .leading)
                            .foregroundStyle(.white)
                            .font(.custom("ArialRoundedMTBold", size: 20))
                        
                    }
                    .padding()
                }), expanded: ExpandedView(content: {
                    VStack(alignment: .leading, spacing: 12)
                    {
                        Text("1.2 发货国与目的国计税原则")
                            .frame(maxWidth: .infinity, alignment: .leading)
                            .foregroundStyle(.white)
                            .font(.custom("ArialRoundedMTBold", size: 28))
                        Text("Reading time: 3 mins")
                                   .font(.custom("ArialRoundedMTBold", size: 14))
                                   .foregroundStyle(.white)
                        Text("在讲述发货国计税原则与目的国计税原则之前，可能需要先要铺垫一下关于欧盟的一些基本情况，解释一下发货国与目的国计税原则的由来，顺便还有一些在后续税表报税中可能会出现的一些名词的解释。")
                                    .font(.custom("ArialRoundedMT", size: 14))
                                    .foregroundStyle(.white)
                        
                                Spacer()
                    }
                    .padding()
                }))
                Group{
                    ExpandableView(thumbnail: ThumbnailView(content: {
                        VStack(alignment: .leading, spacing: 10)
                        {
                            Text("1.2.1 了解欧盟")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 20))
                            
                        }
                        .padding()
                    }), expanded: ExpandedView(content: {
                        VStack(alignment: .leading, spacing: 12)
                        {
                            Text("1.2.1 了解欧盟")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 28))
                            Text("欧盟现在有27个成员国")
                                .font(.custom("ArialRoundedMTBold", size: 14))
                                .foregroundStyle(.white)
                            Text("Austria奥地利🇦🇹 Germany德国🇩🇪 Netherlands荷兰🇳🇱 Belgium比利时🇧🇪 Greece希腊🇬🇷 Poland波兰🇵🇱 Bulgaria保加利亚🇧🇬 Hungary匈牙利🇭🇺 Portugal葡萄牙🇵🇹 Croatia克罗地亚🇭🇷 Ireland爱尔兰🇮🇪 Romania罗马尼亚🇷🇴 Cyprus塞浦路斯🇨🇾 Italy意大利🇮🇹 Slovak Republic斯洛伐克🇸🇰 Czech Republic捷克🇨🇿 Latvia拉脱维亚🇱🇻 Slovenia斯洛文尼亚🇸🇮 Denmark丹麦🇩🇰 Lithuania立陶宛🇱🇹 Spain西班牙🇪🇸 Estonia爱沙尼亚🇪🇪 Luxembourg卢森堡🇱🇺 Sweden瑞典🇸🇪 Finland芬兰🇫🇮 Malta马耳他🇲🇹 France法国🇫🇷")
                                .font(.custom("ArialRoundedMT", size: 14))
                                .foregroundStyle(.white)
                            
                            Spacer()
                        }
                        .padding()
                    }))
                    
                    ExpandableView(thumbnail: ThumbnailView(content: {
                        VStack(alignment: .leading, spacing: 10)
                        {
                            Text("      欧盟的单一市场机制")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 20))
                            
                        }
                        .padding()
                    }), expanded: ExpandedView(content: {
                        VStack(alignment: .leading, spacing: 12)
                        {
                            Text("      欧盟的单一市场机制")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 28))
                            
                            Text("1993年1月1日，欧盟采用了单一市场规则。在这一规则下，货物在成员国之间可以无障碍（包括海关控制）自由移动。所以，“进口”和“出口”的概念已经不适用于欧盟成员国之间的跨境贸易。")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            
                                    Spacer()
                        }
                        .padding()
                    }))
                    
                    
                    ExpandableView(thumbnail: ThumbnailView(content: {
                        VStack(alignment: .leading, spacing: 10)
                        {
                            Text("      进口和出口")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 20))
                            
                        }
                        .padding()
                    }), expanded: ExpandedView(content: {
                        VStack(alignment: .leading, spacing: 12)
                        {
                            Text("      进口和出口")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 28))
                            
                            Text("在欧盟境内，“出口”适用于货物从欧盟境内供应至欧盟境外国家（第三方国家）。“进口”适用于货物从欧盟境外国家进入欧盟境内。货物进口到欧盟内后可“自由流通”，这是指货物在欧盟境内流通无需缴纳关税，也没有其他的边境管制。也就是说，在欧盟境内，是不存在严格意义上的进口和出口。“非应纳税人”是指没有注册VAT的个人或法人实体。在欧盟，货物供应到非应税人士时需要缴纳VAT，使用“发货国原则”，即在货物供应商的国家缴纳VAT。所以，缴纳VAT的税率是供货方所在国家的税率，而不是消费者所在国家的税率。例如：如果一个丹麦游客在巴黎的店铺里买了一件裙子，她应该按照法国的税率20%支付，而不是丹麦25%的税率，即使这件裙子后续将会被“出口”到丹麦。当然，这个规则也是有例外的，包括“货物的远程销售”，“新交通工具”的销售以及销售到“非应纳税人”。")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            
                                    Spacer()
                        }
                        .padding()
                    }))
                    
                    
                    ExpandableView(thumbnail: ThumbnailView(content: {
                        VStack(alignment: .leading, spacing: 10)
                        {
                            Text("      远程销售")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 20))
                            
                        }
                        .padding()
                    }), expanded: ExpandedView(content: {
                        VStack(alignment: .leading, spacing: 12)
                        {
                            Text("      远程销售")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 28))
                            
                            Text("“远程销售”是指供货商（或其代表）从一个欧盟国家将货物销售到另一个欧盟国家的特定类型的消费者手中，这类消费者没有注册VAT税号，例如非应纳税人。一般来说，远程销售包括邮购的货物以及网络购物等。非应纳税人需要承担VAT费用。因为他们不能从销售中收取VAT，也不允许抵消购买时支付的VAT。所以对于非应纳税人，VAT的税率直接影响其购买物品的价格。在单一市场中，非应纳税人会更倾向于购买那些低税率国家的产品，这样发货国原则可能会引起不当竞争，导致一些成员国VAT税收的损失。为了避免这种竞争扭曲，欧盟为非应纳税人（以及在其原籍国未注册VAT的应税人士）制定了“远程销售”的规则。若远程卖家向另一成员国客户提供的货物价值超过了销售额度，该远程卖家必须在另一国家（“目的国”）注册VAT。然后VAT必须在目的国缴纳，适用目的国的税率。每个国家的远程销售额度可以参见各成员国的独立章节。如果销售额度没有超过门槛，远程卖家也可以选择在目的国缴税。否则，在销售额达到门槛前，“发货国原则”仍然适用。请注意，关于远程销售的重大变更已经在2017年12月5日被财政经济理事会（ECOFIN Council）采用，将在2019年和2021年分两个阶段实施（见下文“数字化单一市场”）。欧盟内部应纳税人的交易。欧盟内部交易下的应纳税人是指在欧盟注册了VAT的个人或法人实体。鉴于单一市场内部没有海关控制，欧盟内部应纳税的交易不再称作“进口”和“出口”（见进口及出口部门），而是称作“欧盟内的购买”和“欧盟内的供应”。总的来说，应税人士的跨境货物供应，VAT的征收使用的是“目的国原则”。在这一原则下，VAT不是在货物供应国（称作“发货国”）缴纳，而是在货物送达的国家（称作“目的国”）缴纳。")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            
                                    Spacer()
                        }
                        .padding()
                    }))
                    
                    ExpandableView(thumbnail: ThumbnailView(content: {
                        VStack(alignment: .leading, spacing: 10)
                        {
                            Text("      欧盟内部供应")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 20))
                            
                        }
                        .padding()
                    }), expanded: ExpandedView(content: {
                        VStack(alignment: .leading, spacing: 12)
                        {
                            Text("      欧盟内部供应")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 28))
                            
                            Text("欧盟内部的货物供应是“零税率”，例如，这就意味着无需缴纳VAT，但是供应商有权抵扣购买时缴纳的VAT。供应商必须证明货物发往了另一个欧盟成员国的应税人士。供应商需要提供客户的EU VAT注册号，包括该国家名字的前缀（例如：BE是比利时的前缀），特殊情况除外。每个成员国需要的文件略有差异，详细信息请参见后续章节。")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            
                                    Spacer()
                        }
                        .padding()
                    }))
                    
                    ExpandableView(thumbnail: ThumbnailView(content: {
                        VStack(alignment: .leading, spacing: 10)
                        {
                            Text("      欧盟内的购买")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 20))
                            
                        }
                        .padding()
                    }), expanded: ExpandedView(content: {
                        VStack(alignment: .leading, spacing: 12)
                        {
                            Text("      欧盟内的购买")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 28))
                            
                            Text("欧盟内的购买是指一个应税人士从另一个欧盟成员国购买货物。欧盟内购买最初应该在发放VAT识别号的国家缴纳，除非购买货物的人士可以证明货物已经在目的国以当地税率缴纳VAT。购买税作为销项税（销项VAT）由应税人员自行衡量。若购买方有权将购买时缴纳的VAT作为进项税（进项VAT），则可以在申报销项税的同时进行进项税的抵扣。最终购买者抵扣了全部的进项税，在欧盟内部购买时实际上并没有支付VAT。")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            Text("若一家企业在另一个没有注册VAT的成员国进行欧盟内购买，则可能需要注册该国家的VAT。")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                                    Spacer()
                        }
                        .padding()
                    }))
                    
                    ExpandableView(thumbnail: ThumbnailView(content: {
                        VStack(alignment: .leading, spacing: 10)
                        {
                            Text("      内部反向征税机制")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 20))
                            
                        }
                        .padding()
                    }), expanded: ExpandedView(content: {
                        VStack(alignment: .leading, spacing: 12)
                        {
                            Text("      内部反向征税机制")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 28))
                            
                            Text("为了打击税务欺诈，各成员国也采用了相似的规定。当客户承担购买国内供应品的VAT时，包括手机、集成电路器件、游戏机、平板电脑和笔记本、谷类食品和工业原料作物、以及原材料和半成品金属。当客户有权将进口VAT作为进项税抵扣时，便可以在申报销项税时抵扣进项税。采用反向征税机制，客户实际上是不需要支付任何VAT的。")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            
                                    Spacer()
                        }
                        .padding()
                    }))
                    
                    ExpandableView(thumbnail: ThumbnailView(content: {
                        VStack(alignment: .leading, spacing: 10)
                        {
                            Text("      分支机构的货物转移")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 20))
                            
                        }
                        .padding()
                    }), expanded: ExpandedView(content: {
                        VStack(alignment: .leading, spacing: 12)
                        {
                            Text("      分支机构的货物转移")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 28))
                            
                            Text("同一家法人实体不同部门之间的货物转移通常是不缴纳VAT的（例如一个成员国内一家公司的货物从工厂运输到仓库是不需要缴纳VAT的）。但是，若在欧盟内产生跨境行为，则不适用。若在不同成员国之间进行同一法人实体不同部门间的货物转移，则视为应税人士进行欧盟内部的供应和购买。例如，当货物在同一公司的不同成员国分部间转移，或当货物制造完成后，在销售前运往另一成员国的仓库存放，则视为购买。若视为购买，转移货物的人需要在发货国和目的国都注册VAT。")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            
                                    Spacer()
                        }
                        .padding()
                    }))
                    
                    ExpandableView(thumbnail: ThumbnailView(content: {
                        VStack(alignment: .leading, spacing: 10)
                        {
                            Text("      欧盟内供货至非应纳税人")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 20))
                            
                        }
                        .padding()
                    }), expanded: ExpandedView(content: {
                        VStack(alignment: .leading, spacing: 12)
                        {
                            Text("      欧盟内供货至非应纳税人")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 28))
                            
                            Text("不属于“纳税人士”范围的即是“非应税人士”。“非应税人士”在广义上是指未注册VAT以及未进行经济活动的任何个人或法人实体。在欧盟境内，VAT主要向货物供应的非应税人士收取，使用“发货国原则”，这就意味着VAT适用于货物供应商的所在国家。所以，缴纳VAT的税率是供货方所在国家的税率，而不是消费者所在国家的税率。例如：如果一个丹麦游客在巴黎的店铺里买了一件裙子，她应该按照法国的税率20%支付，而不是丹麦25%的税率，即使这件裙子后续将会被“出口”到丹麦。当然，这个规则也是有例外的，包括“货物的远程销售”，“新交通工具”的销售以及销售到“非应税法人”。")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            
                                    Spacer()
                        }
                        .padding()
                    }))
                    ExpandableView(thumbnail: ThumbnailView(content: {
                        VStack(alignment: .leading, spacing: 10)
                        {
                            Text("      VAT申报")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 20))
                            
                        }
                        .padding()
                    }), expanded: ExpandedView(content: {
                        VStack(alignment: .leading, spacing: 12)
                        {
                            Text("      VAT申报")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 28))
                            
                            Text("2016年6月，欧盟委员会采用了一项指令，统一了欧盟VAT付款凭证的处理方式。该指令区别了单用途付款凭证和多用途付款凭证。单用途付款凭证的定义是“供应货物或服务的地点的付款凭证，以及付款凭证相关的信息；开具付款证明时会知道应付增值税的日期”，其他的付款凭证均为多用途付款凭证。由以自己名义行事的纳税人转让单一用途凭证被视为该凭证所涉及的商品或服务的供应。 实际交付货物或实际提供服务以换取供应商考虑接受的单一用途凭证不被视为独立交易。 但是，在将多用途凭证作为实际移交货物或实际提供服务的对价之前，转让多用途凭证不需缴纳增值税。新法规2018年12月31日起生效。")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            
                            Text("欧盟委员会于2018年1月28日提出新规，给予在各成员国有交易的小企业更多的灵活性。现在成员国对于未达到固定年收入的小企业可以免征收VAT，每个国家的限额不同。此外，简化原则只在本国适用，这意味着跨境交易的企业无法在其他国家享受免税和简化原则。")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            
                            Text("当前的免税额度依然有效，同时加入了新规：")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            
                            Text("• 欧盟内收入低于200万欧元的小企业可以使用简化原则，不论其是否已经免征收VAT")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            Text("• 成员国免征所有符合资格小企业的VAT，包括认证、发票、会计或申报等义务")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            
                            Text("• 营业额低于10万欧元的小企业（在超过一个欧盟国家运营），可以在所有欧盟国家免征收VAT，并且享受简化原则。")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                                    Spacer()
                        }
                        .padding()
                    }))
                }
                
                
                Group{
                    ExpandableView(thumbnail: ThumbnailView(content: {
                        VStack(alignment: .leading, spacing: 10)
                        {
                            Text("2.1 税务范围")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 20))
                            
                        }
                        .padding()
                    }), expanded: ExpandedView(content: {
                        VStack(alignment: .leading, spacing: 12)
                        {
                            Text("2.1 税务范围")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.white)
                                .font(.custom("ArialRoundedMTBold", size: 28))
                            
                            Text("·在成员国境内由作为应税人的个体以对价供应货物")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            Text("·在成员国境内由作为应税人的个体（以及其他情况下）进行欧盟内部采购的货物，并以对价进行交易。")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            Text("·在成员国境内由作为应税人的个体以对价供应服务")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            
                            Text("·在成员国境内由作为应税人的个体以对价供应服务。")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                            
                            Text("·进口货物（无论进口商的地位如何）。")
                                        .font(.custom("ArialRoundedMT", size: 14))
                                        .foregroundStyle(.white)
                                    Spacer()
                        }
                        .padding()
                    }))
                    
                    
                    
                    
                }
            }
        }
        .navigationTitle("VAT法规")
    }
}

#Preview {
    CultivateView_Law_VAT()
}
