package net.engawapg.composebooksamples.practicaluiexample

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WikiViewScreen(url: String, onCloseClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onCloseClick) {
                        Icon(
                            painter = painterResource(R.drawable.close),
                            contentDescription = "閉じる"
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        AndroidView(
            modifier = Modifier.padding(innerPadding),
            factory = { context ->
                WebView(context).apply {
                    webViewClient = WebViewClient()
                }
            },
            update = { webView ->
                webView.loadUrl(url)
            }
        )
    }
}
