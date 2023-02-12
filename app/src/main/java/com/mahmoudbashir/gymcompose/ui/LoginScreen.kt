package com.mahmoudbashir.gymcompose.ui


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(onLoginSuccess:()->Unit){
    Column {
        InputFields{
            onLoginSuccess()
        }
    }
}

@Composable
fun InputFields(onLoginSuccess:()->Unit){

    val mContext = LocalContext.current
    var email by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var pass by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var isBtnEnabled by remember {
        mutableStateOf(false)
    }
    var isEmailError by remember {
        mutableStateOf(false)
    }
    var isPassError by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FieldDesign(modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),
             email,
            "email",
            "",
            KeyboardType.Email,
            Icons.Default.Email,
            isEmailError
        ){_email->
            email = _email
            isEmailError = email.text.isEmpty()

        }
        Spacer(modifier = Modifier.height(10.dp))
        FieldDesign(modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),
            pass,
            "Password",
            "",
            KeyboardType.Password,
            Icons.Default.Lock,
            isPassError,
            PasswordVisualTransformation()
        ){_pass->
            pass = _pass
            isPassError = pass.text.isEmpty()

            isBtnEnabled = email.text.isNotEmpty() && pass.text.isNotEmpty() &&
                    pass.text.length>6
        }

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            onClick = {
                isEmailError = email.text.isEmpty()
                isPassError = pass.text.isEmpty()

                if (!isEmailError && !isPassError){
                    onLoginSuccess()
                }
            },
            modifier = Modifier
                .height(45.dp)
                .fillMaxWidth()
                .clip(RectangleShape),
//            .clipToBounds()
//            .border(BorderStroke(1.dp, Color.Blue), RectangleShape)
            colors = ButtonDefaults.btnDefaults(),
            enabled = isBtnEnabled
        ) {
            Text(text = "Sign in",
            style = TextStyle(
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
            )
            )
        }
    }
}

@Composable
fun ButtonDefaults.btnDefaults():ButtonColors{
   return buttonColors(
        backgroundColor = Color.Yellow ,
        contentColor = Color.DarkGray,
       disabledBackgroundColor = Color.DarkGray,
       disabledContentColor = Color.Yellow
    )
}

@Composable
fun FieldDesign(modifier: Modifier, fieldValue: TextFieldValue, label: String, placeholder: String, keyType: KeyboardType, icon: ImageVector,isError:Boolean,visualTransformation: VisualTransformation?=null,valueChanged:(TextFieldValue)->Unit) {
    OutlinedTextField(modifier =modifier,
        value = fieldValue,
        label = { Text(text = label)},
        placeholder = { Text(text = placeholder)},
        keyboardOptions = KeyboardOptions(keyboardType =
        keyType),
        visualTransformation = visualTransformation?: VisualTransformation.None,
        leadingIcon = { Icon(imageVector = icon,
            contentDescription = null)},
        onValueChange = {_email->
            valueChanged(_email)
        },
        isError = isError,
    )
}
