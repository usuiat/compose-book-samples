package net.engawapg.composebooksamples.composemechanismsample

import android.os.Parcelable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import kotlinx.parcelize.Parcelize

@Composable
fun RememberSaveableSample() {
    var count by rememberSaveable { mutableIntStateOf(0) }
    Button(onClick = { count++ }) { Text("count=$count") }
}

@Parcelize
class SomeClass(
    val x: Int = 0,
    val y: String = ""
): Parcelable

@Composable
fun ParcelableClassUsageSample() {
    val someObject1 = rememberSaveable { SomeClass() }
    var someObject2 by rememberSaveable { mutableStateOf(SomeClass()) }

    Column {
        Button(
            onClick = { someObject2 = SomeClass(x = 2, y = "test") }
        ) {
            Text("Button")
        }
        Text("someObject2 x=${someObject2.x} y=${someObject2.y}")
    }
}

class OtherClass(
    val x: Int = 0,
    val y: String = ""
) {
    companion object {
        val Saver = mapSaver(
            save = {
                mapOf("x" to it.x, "y" to it.y)
            },
            restore = {
                val x = it["x"] as Int
                val y = it["y"] as String
                OtherClass(x, y)
            }
        )
    }
}

@Composable
fun SaverUsageSample() {
    val otherObject1 = rememberSaveable(saver = OtherClass.Saver) {
        OtherClass()
    }
    var otherObject2 by rememberSaveable(stateSaver = OtherClass.Saver) {
        mutableStateOf(OtherClass())
    }

    Column {
        Button(
            onClick = { otherObject2 = OtherClass(x = 2, y = "test") }
        ) {
            Text("Button")
        }
        Text("otherObject2 x=${otherObject2.x} y=${otherObject2.y}")
    }
}
