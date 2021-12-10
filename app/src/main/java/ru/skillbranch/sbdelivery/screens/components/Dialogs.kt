package ru.skillbranch.sbdelivery.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.screens.root.ui.AppTheme

@Composable
fun AboutDialog(onDismiss: () -> Unit) {

    Dialog(onDismissRequest = { onDismiss.invoke() }, properties = DialogProperties()) {
        AboutDialogContent {
            onDismiss.invoke()
        }
    }
}

@Composable
fun AboutDialogContent(onDismiss: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        ConstraintLayout(
            modifier = Modifier.background(MaterialTheme.colors.onPrimary).padding(bottom = 16.dp)
        ) {
            val (title, text, cancelButton, acceptButton) = createRefs()

            IconButton(
                onClick = { onDismiss.invoke() },
                modifier = Modifier.constrainAs(cancelButton) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
            ) {
                Icon(
                    tint = MaterialTheme.colors.primary,
                    painter = painterResource(id = R.drawable.ic_baseline_close_24),
                    contentDescription = "Toggle favorite"
                )
            }

            Text(
                text = "О приложении",
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(cancelButton.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            Text(
                text = "Применение Jetpack Compose для верстки пользовательских интерфейсов с использованием декларативного подхода при создании UI",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.constrainAs(text) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }.padding(top = 16.dp, bottom = 16.dp),
                textAlign = TextAlign.Center
            )

            TextButton(
                onClick = { onDismiss.invoke() },
                modifier = Modifier
                    .background(MaterialTheme.colors.secondary, RoundedCornerShape(4.dp))
                    .constrainAs(acceptButton) {
                    top.linkTo(text.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) {
                Text(
                    text = "Ok",
                    color = MaterialTheme.colors.onSecondary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
fun AboutDialogPreview() {
    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(20.dp),
            contentAlignment = Alignment.Center,
        ) {
            AboutDialogContent {

            }
        }
    }
}