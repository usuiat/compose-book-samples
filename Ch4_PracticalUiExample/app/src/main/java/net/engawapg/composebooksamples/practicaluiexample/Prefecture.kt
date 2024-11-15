package net.engawapg.composebooksamples.practicaluiexample

import androidx.annotation.DrawableRes

data class Prefecture(
    val name: String,
    val area: String, // km²
    val population: String, // 万人
    val capital: String,
    val description: String,
    val wikiUrl: String,
    @DrawableRes val imageRes: Int,
)

val Prefectures = listOf(
    Prefecture(
        "北海道",
        "83,456㎢",
        "525万人",
        "札幌市",
        "日本の最北端に位置し、広大な大地と豊かな自然が広がる。農業や酪農が盛んで、新鮮な食材が豊富。冬には雪まつりなど、魅力的なイベントが開催される。",
        "https://ja.wikipedia.org/wiki/北海道",
        R.drawable.hokkaido,
    ),
    Prefecture(
        "青森県",
        "9,645㎢",
        "125万人",
        "青森市",
        "本州最北端に位置し、世界遺産の白神山地やねぶた祭で知られる。りんごの生産量が日本一で、豊かな自然と伝統文化が魅力。",
        "https://ja.wikipedia.org/wiki/青森県",
        R.drawable.aomori,
    ),
    Prefecture(
        "岩手県",
        "15,278㎢",
        "123万人",
        "盛岡市",
        "東北地方に位置し、世界遺産の平泉や厳美渓などの景勝地を有する。わんこそばや南部鉄器など、独自の食文化や伝統工芸も魅力。",
        "https://ja.wikipedia.org/wiki/岩手県",
        R.drawable.iwate,
    ),
    Prefecture(
        "宮城県",
        "7,285㎢",
        "231万人",
        "仙台市",
        "東北地方最大の都市・仙台市を擁する。伊達政宗ゆかりの地であり、歴史的な建造物や史跡も多い。牛タン焼きや笹かまぼこなど、グルメも充実。",
        "https://ja.wikipedia.org/wiki/宮城県",
        R.drawable.miyagi,
    ),
    Prefecture(
        "秋田県",
        "11,637㎢",
        "97万人",
        "秋田市",
        "日本海側に位置し、豊かな自然と温泉が魅力。秋田犬や竿燈まつりなど、独自の文化も育まれてきた。きりたんぽ鍋や稲庭うどんなど、郷土料理も豊富。",
        "https://ja.wikipedia.org/wiki/秋田県",
        R.drawable.akita,
    ),
    Prefecture(
        "山形県",
        "9,323㎢",
        "108万人",
        "山形市",
        "東北地方に位置し、さくらんぼの生産量が日本一。山寺や蔵王温泉など、自然豊かな観光地も多い。芋煮や冷たい肉そばなど、郷土料理も楽しめる。",
        "https://ja.wikipedia.org/wiki/山形県",
        R.drawable.yamagata,
    ),
    Prefecture(
        "福島県",
        "13,783㎢",
        "185万人",
        "福島市",
        "東北地方に位置し、会津若松や磐梯山など、歴史と自然が豊かな観光地が多い。桃や梨などの果物の生産も盛ん。",
        "https://ja.wikipedia.org/wiki/福島県",
        R.drawable.fukushima,
    ),
    Prefecture(
        "茨城県",
        "6,095㎢",
        "286万人",
        "水戸市",
        "関東地方の北東部に位置し、広大な平野が広がる。農業が盛んで、メロンや納豆の生産量が日本一。",
        "https://ja.wikipedia.org/wiki/茨城県",
        R.drawable.ibaraki,
    ),
    Prefecture(
        "栃木県",
        "6,408㎢",
        "193万人",
        "宇都宮市",
        "関東地方の北部に位置し、日光国立公園など自然豊かな観光地が多い。世界遺産の日光東照宮も有名。",
        "https://ja.wikipedia.org/wiki/栃木県",
        R.drawable.tochigi,
    ),
    Prefecture(
        "群馬県",
        "6,362㎢",
        "194万人",
        "前橋市",
        "関東地方の北西部に位置し、草津温泉や伊香保温泉など、多くの温泉地を有する。",
        "https://ja.wikipedia.org/wiki/群馬県",
        R.drawable.gunma,
    ),
    Prefecture(
        "埼玉県",
        "3,797㎢",
        "735万人",
        "さいたま市",
        "関東地方の中央部に位置し、東京のベッドタウンとして発展してきた。",
        "https://ja.wikipedia.org/wiki/埼玉県",
        R.drawable.saitama,
    ),
    Prefecture(
        "千葉県",
        "5,156㎢",
        "626万人",
        "千葉市",
        "関東地方の南東部に位置し、東京ディズニーリゾートや成田国際空港など、多くの観光客が訪れる。",
        "https://ja.wikipedia.org/wiki/千葉県",
        R.drawable.chiba,
    ),
    Prefecture(
        "東京都",
        "2,187㎢",
        "1,393万人",
        "新宿区",
        "日本の首都であり、政治・経済・文化の中心地。世界有数の観光都市でもある。",
        "https://ja.wikipedia.org/wiki/東京都",
        R.drawable.tokyo,
    ),
    Prefecture(
        "神奈川県",
        "2,415㎢",
        "920万人",
        "横浜市",
        "関東地方の南西部に位置し、横浜中華街や鎌倉など、人気の観光地が多い。",
        "https://ja.wikipedia.org/wiki/神奈川県",
        R.drawable.kanagawa,
    ),
    Prefecture(
        "新潟県",
        "12,583㎢",
        "222万人",
        "新潟市",
        "日本海側に位置し、雄大な自然と豊かな食文化が魅力。米の生産量が日本一。",
        "https://ja.wikipedia.org/wiki/新潟県",
        R.drawable.nigata,
    ),
    Prefecture(
        "富山県",
        "4,247㎢",
        "104万人",
        "富山市",
        "日本海側に位置し、立山黒部アルペンルートなど、雄大な山岳景観が魅力。",
        "https://ja.wikipedia.org/wiki/富山県",
        R.drawable.toyama,
    ),
    Prefecture(
        "石川県",
        "4,185㎢",
        "114万人",
        "金沢市",
        "日本海側に位置し、兼六園や金沢21世紀美術館など、伝統と現代アートが融合する都市・金沢が人気。",
        "https://ja.wikipedia.org/wiki/石川県",
        R.drawable.ishikawa,
    ),
    Prefecture(
        "福井県",
        "4,188㎢",
        "77万人",
        "福井市",
        "日本海側に位置し、恐竜博物館や永平寺など、個性的な観光スポットが多い。",
        "https://ja.wikipedia.org/wiki/福井県",
        R.drawable.fukui,
    ),
    Prefecture(
        "山梨県",
        "4,465㎢",
        "81万人",
        "甲府市",
        "富士山や南アルプスなど、雄大な山々に囲まれた県。ぶどうや桃などの果物の生産が盛ん。",
        "https://ja.wikipedia.org/wiki/山梨県",
        R.drawable.yamagata,
    ),
    Prefecture(
        "長野県",
        "13,562㎢",
        "205万人",
        "長野市",
        "本州の中部に位置し、日本アルプスや善光寺など、自然と歴史が豊かな観光地が多い。",
        "https://ja.wikipedia.org/wiki/長野県",
        R.drawable.nagano,
    ),
    Prefecture(
        "岐阜県",
        "10,621㎢",
        "199万人",
        "岐阜市",
        "中部地方に位置し、白川郷や飛騨高山など、世界遺産を含む歴史的な街並みが魅力。",
        "https://ja.wikipedia.org/wiki/岐阜県",
        R.drawable.gifu,
    ),
    Prefecture(
        "静岡県",
        "7,777㎢",
        "364万人",
        "静岡市",
        "中部地方に位置し、富士山や伊豆半島など、変化に富んだ自然景観が魅力。",
        "https://ja.wikipedia.org/wiki/静岡県",
        R.drawable.shizuoka,
    ),
    Prefecture(
        "愛知県",
        "5,163㎢",
        "755万人",
        "名古屋市",
        "中部地方最大の都市・名古屋市を擁する。トヨタ自動車など、自動車産業が盛ん。",
        "https://ja.wikipedia.org/wiki/愛知県",
        R.drawable.aichi,
    ),
    Prefecture(
        "三重県",
        "5,777㎢",
        "178万人",
        "津市",
        "近畿地方に位置し、伊勢神宮や熊野古道など、世界遺産を含む歴史的な観光地が多い。",
        "https://ja.wikipedia.org/wiki/三重県",
        R.drawable.mie,
    ),
    Prefecture(
        "滋賀県",
        "4,017㎢",
        "141万人",
        "大津市",
        "近畿地方に位置し、日本最大の湖である琵琶湖を有する。豊かな自然と歴史的な景観が魅力。",
        "https://ja.wikipedia.org/wiki/滋賀県",
        R.drawable.shiga,
    ),
    Prefecture(
        "京都府",
        "4,612㎢",
        "258万人",
        "京都市",
        "近畿地方に位置し、千年の都として栄えた歴史と文化が息づく。多くの観光名所がある。",
        "https://ja.wikipedia.org/wiki/京都府",
        R.drawable.kyoto,
    ),
    Prefecture(
        "大阪府",
        "1,905㎢",
        "881万人",
        "大阪市",
        "近畿地方最大の都市・大阪市を擁する。商人の街として発展し、活気あふれる雰囲気。",
        "https://ja.wikipedia.org/wiki/大阪府",
        R.drawable.osaka,
    ),
    Prefecture(
        "兵庫県",
        "8,400㎢",
        "547万人",
        "神戸市",
        "近畿地方に位置し、神戸や姫路など、国際的な港町や城下町が魅力。",
        "https://ja.wikipedia.org/wiki/兵庫県",
        R.drawable.hyogo,
    ),
    Prefecture(
        "奈良県",
        "3,690㎢",
        "133万人",
        "奈良市",
        "近畿地方に位置し、東大寺や興福寺など、多くの歴史的建造物を有する。",
        "https://ja.wikipedia.org/wiki/奈良県",
        R.drawable.nara,
    ),
    Prefecture(
        "和歌山県",
        "4,725㎢",
        "93万人",
        "和歌山市",
        "近畿地方に位置し、高野山や熊野古道など、世界遺産を含む自然豊かな観光地が多い。",
        "https://ja.wikipedia.org/wiki/和歌山県",
        R.drawable.wakayama,
    ),
    Prefecture(
        "鳥取県",
        "3,507㎢",
        "56万人",
        "鳥取市",
        "中国地方に位置し、鳥取砂丘など雄大な自然景観が魅力。砂丘でのラクダ乗りや砂の美術館など、ユニークな体験もできる。",
        "https://ja.wikipedia.org/wiki/鳥取県",
        R.drawable.tottori,
    ),
    Prefecture(
        "島根県",
        "6,708㎢",
        "67万人",
        "松江市",
        "中国地方に位置し、出雲大社や石見銀山など、歴史的な観光スポットが多い。神話の国としても知られ、神秘的な雰囲気も漂う。",
        "https://ja.wikipedia.org/wiki/島根県",
        R.drawable.shimane,
    ),
    Prefecture(
        "岡山県",
        "7,114㎢",
        "190万人",
        "岡山市",
        "中国地方に位置し、倉敷美観地区や後楽園など、美しい景観が魅力。桃太郎伝説の舞台としても知られ、フルーツ王国としても有名。",
        "https://ja.wikipedia.org/wiki/岡山県",
        R.drawable.okayama,
    ),
    Prefecture(
        "広島県",
        "8,479㎢",
        "280万人",
        "広島市",
        "中国地方に位置し、世界遺産の厳島神社や原爆ドームなど、歴史的な建造物を有する。お好み焼きや牡蠣など、食文化も豊か。",
        "https://ja.wikipedia.org/wiki/広島県",
        R.drawable.hiroshima,
    ),
    Prefecture(
        "山口県",
        "6,112㎢",
        "135万人",
        "山口市",
        "中国地方に位置し、秋吉台や錦帯橋など、自然豊かな観光スポットが多い。ふぐの本場としても知られ、美味しい郷土料理も楽しめる。",
        "https://ja.wikipedia.org/wiki/山口県",
        R.drawable.yamaguchi,
    ),
    Prefecture(
        "徳島県",
        "4,146㎢",
        "72万人",
        "徳島市",
        "四国地方に位置し、阿波踊りで有名。鳴門の渦潮や祖谷渓など、自然豊かな観光スポットも多い。",
        "https://ja.wikipedia.org/wiki/徳島県",
        R.drawable.tokushima,
    ),
    Prefecture(
        "香川県",
        "1,876㎢",
        "95万人",
        "高松市",
        "四国地方に位置し、うどん県として知られる。直島や小豆島など、アートと自然が融合した島々も魅力。",
        "https://ja.wikipedia.org/wiki/香川県",
        R.drawable.kagawa,
    ),
    Prefecture(
        "愛媛県",
        "5,676㎢",
        "133万人",
        "松山市",
        "四国地方に位置し、道後温泉や松山城など、歴史的な観光スポットが多い。みかんの生産も盛んで、美しいリアス式海岸も魅力。",
        "https://ja.wikipedia.org/wiki/愛媛県",
        R.drawable.ehime,
    ),
    Prefecture(
        "高知県",
        "7,104㎢",
        "70万人",
        "高知市",
        "四国地方に位置し、坂本龍馬の出身地として知られる。四万十川や桂浜など、雄大な自然が魅力で、カツオのたたきなどの郷土料理も有名。",
        "https://ja.wikipedia.org/wiki/高知県",
        R.drawable.kochi,
    ),
    Prefecture(
        "福岡県",
        "4,986㎢",
        "511万人",
        "福岡市",
        "九州地方に位置し、博多ラーメンやもつ鍋など、食文化が豊かな都市・福岡市を擁する。太宰府天満宮や柳川など、歴史的な観光地も多い。",
        "https://ja.wikipedia.org/wiki/福岡県",
        R.drawable.fukuoka,
    ),
    Prefecture(
        "佐賀県",
        "2,440㎢",
        "81万人",
        "佐賀市",
        "九州地方に位置し、有田焼や伊万里焼など、焼き物の産地として有名。吉野ヶ里遺跡や武雄温泉など、歴史と自然が楽しめる観光スポットも多い。",
        "https://ja.wikipedia.org/wiki/佐賀県",
        R.drawable.saga,
    ),
    Prefecture(
        "長崎県",
        "4,132㎢",
        "132万人",
        "長崎市",
        "九州地方に位置し、異国情緒あふれる街並みが魅力。世界遺産の軍艦島やグラバー園など、歴史的な観光スポットも多い。",
        "https://ja.wikipedia.org/wiki/長崎県",
        R.drawable.nagasaki,
    ),
    Prefecture(
        "熊本県",
        "7,409㎢",
        "174万人",
        "熊本市",
        "九州地方に位置し、熊本城や阿蘇山など、雄大な自然と歴史が魅力。くまモンも大人気で、馬刺しや辛子蓮根などの郷土料理も楽しめる。",
        "https://ja.wikipedia.org/wiki/熊本県",
        R.drawable.kumamoto,
    ),
    Prefecture(
        "大分県",
        "6,340㎢",
        "113万人",
        "大分市",
        "九州地方に位置し、別府温泉や湯布院温泉など、日本有数の温泉地を有する。高崎山自然動物園や耶馬渓など、自然豊かな観光スポットも多い。",
        "https://ja.wikipedia.org/wiki/大分県",
        R.drawable.oita,
    ),
    Prefecture(
        "宮崎県",
        "7,735㎢",
        "107万人",
        "宮崎市",
        "九州地方に位置し、温暖な気候と美しい海岸線が魅力。高千穂峡や青島神社など、神話に彩られた神秘的な観光スポットも多い。",
        "https://ja.wikipedia.org/wiki/宮崎県",
        R.drawable.miyazaki,
    ),
    Prefecture(
        "鹿児島県",
        "9,188㎢",
        "160万人",
        "鹿児島市",
        "九州地方に位置し、桜島や屋久島など、雄大な自然が魅力。黒豚や焼酎など、特産品も豊富で、歴史的な史跡も多い。",
        "https://ja.wikipedia.org/wiki/鹿児島県",
        R.drawable.kagoshima,
    ),
    Prefecture(
        "沖縄県",
        "2,281㎢",
        "146万人",
        "那覇市",
        "日本最南端に位置し、美しい海と独特の文化が魅力。首里城や美ら海水族館など、人気の観光スポットも多い。",
        "https://ja.wikipedia.org/wiki/沖縄県",
        R.drawable.okinawa,
    )
)
