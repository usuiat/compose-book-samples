# 『詳解 Jetpack Compose』サンプルコード

このリポジトリでは、『詳解 Jetpack Compose』のサンプルコードを公開しています。

## 書籍について

臼井 篤志 著  
『詳解 Jetpack Compose ── 基礎から学ぶAndroidアプリの宣言的UI』  
技術評論社、2024年

- サポートページ  
https://gihyo.jp/book/2024/978-4-297-14488-3

## 内容

このリポジトリは20個のプロジェクトで構成され、1つのプロジェクトに1つのサンプルアプリを実装しています。

第1章と第2章のアプリは、Composeの初心者がコードを読めるように、1画面だけで構成されるシンプルな作りになっています。
第3章以降は、一つのアプリの中にいろいろなサンプルを含んだ作りになっています。

|プロジェクト|対象箇所|説明|
|--|--|--|
Ch1_Sec1_1_HelloCompose|1.1節|Buttonをタップすると文字列を表示するComposeのサンプル|
Ch1_Sec1_2_HelloView|1.1節|Ch1_Sec1_1_HelloComposeと同じUIをViewで記述したサンプル|
Ch1_Sec2_DataBinding|1.2節|Ch1_Sec1_1_HelloComposeと同じUIをDataBindingで記述したサンプル|
Ch1_Sec3_1_ListView|1.3節|リストをComposeで実装したサンプル|
Ch1_Sec3_2_ListCompose|1.3節|Ch1_Sec3_1_ListViewと同じリストをViewで実装したサンプル|
Ch1_Sec4_SwitchCompose|1.4節|Composeのスイッチの状態管理を説明するサンプル|
Ch2_Sec2_HelloCompose|2.2節|Hello, Compose!と表示するサンプル|
Ch2_Sec3_1_TextSamples|2.3節|`Text`を利用して文字列を表示するサンプル|
Ch2_Sec3_2_ImageSamples|2.3節|`Image`を利用して画像を表示するサンプル|
Ch2_Sec4_ModifierSamples|2.4節|`Modifier`を利用してコンポーザブルの見た目や振る舞いをカスタマイズするサンプル|
Ch2_Sec5_LayoutSamples|2.5節|`Column`、`Row`、`Box`を利用して複数のコンポーザブルを配置するサンプル|
Ch2_Sec6_InteractiveUiSamples|2.6節|動的に表示を変更するサンプル|
Ch2_Sec7_StructuredUiSample|2.7節|階層化と構造化により、複雑なUIをシンプルなコードで記述するサンプル|
Ch2_Sec8_PreviewSamples|2.8節|On/Offスイッチのプレビューを表示するサンプル|
Ch3_KotlinUsageSample|第3章|<li>デフォルト引数を活用した`AlertDialog`や`OutlinedTextField`の利用例</li><li>コンポーザブル関数のラムダと通常関数のラムダを含むコードのサンプル</li><li>拡張関数のサンプル</li><li>委譲プロパティのサンプル</li>|
Ch4_PracticalUiExample|第4章|都道府県を紹介するサンプルアプリ|
Ch5_ComposeMechanismSample|第5章|<li>再コンポーズの起点、範囲、スキップを説明するサンプル</li><li>際コンポーズによりコンポジションの構造を変更するサンプル</li><li>Strong Skipping Modeで表示が正しく更新される記述方法のサンプル</li><li>`remember`、`rememberSaveable`のサンプル</li><li>Coroutineのサンプル</li><li>副作用API（`SideEffect`、`LaunchedEffect`、`DisposableEffect`、`rememberCoroutineScope`、`rememberUpdatedState`）のサンプル</li><li>Composeの作用と副作用の境界を説明するサンプル</li><li>単方向データフロー（UDF）のサンプル</li><li>CompositionLocalのサンプル</li>|
Ch6_DesignPattern|第6章|<li>ステートフルなコンポーザブルとステートレスなコンポーザブルのサンプル</li><li>クリックするたびに色が変化する`ColorfulBox`の状態をカプセル化するサンプル</li><li>Flowのサンプル</li><li>MVVMアーキテクチャによるTODOアプリの実装例</li>|
Ch7_Performance|第7章|<li>大量の再コンポーズが発生するコードの例、大きな画像と小さな画像を表示する例</li><li>フェーズを意識してパフォーマンスを改善する例</li><li>`derivedStateOf`を利用してパフォーマンスを改善する例</li><li>`@Immutable`を利用してパフォーマンスを改善する例</li><li>Lazyコンポーザブルを利用してパフォーマンスを改善する例</li>|
Ch8_ComposeTest|第8章|商品の数量を入力する`QuantityPicker`コンポーザブルのテストの実装例|

## ライセンス

このリポジトリ内のコードは全てMITライセンスのもとで公開します。
