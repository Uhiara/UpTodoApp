package com.example.mytodoapplication.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytodoapplication.R
import com.example.mytodoapplication.ui.theme.BlueGray
import com.example.mytodoapplication.ui.theme.LightPurple

@Composable
fun ImageComponent(imageValue: Int) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.36f)
            .padding(horizontal = 30.dp),
        painter = painterResource(id = imageValue),
        contentDescription = ""
    )
}

@Preview(showBackground = true)
@Composable
fun ImageComponentPreview() {
    ImageComponent(R.drawable.onboarding1)
}

@Composable
fun TextComponent(
    modifier: Modifier,
    textValue: String,
    textSize: TextUnit,
    fontWeight: FontWeight,
    fontFamily: FontFamily,
    textAlign: TextAlign,
    colorValue: Color = Color.Black
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = textValue,
        fontSize = textSize,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        textAlign = textAlign,
        color = colorValue,
    )
}

@Preview
@Composable
fun TextComponentPreview() {
    TextComponent(
        modifier = Modifier.fillMaxWidth(),
        textValue = "Manage your tasks",
        textSize = 32.sp,
        fontWeight = FontWeight(400),
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun ButtonComponent(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White,
        ),
        shape = RoundedCornerShape(size = 4.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}

@Preview
@Composable
fun ButtonComponentPreview() {
    ButtonComponent(text = "Login") {

    }
}


@Composable
fun TextButtonComponent(
    text: String,
    onClick: () -> Unit,
) {
    TextButton(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, color = MaterialTheme.colorScheme.primary),
        onClick = onClick,
        shape = RoundedCornerShape(size = 4.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
            color = BlueGray
        )
    }
}

@Preview
@Composable
fun TextButtonComponentPreview() {
    TextButtonComponent(text = "Create Account") {

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    modifier: Modifier,
    labelValue: String,
) {
    var textValue by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp)),
        value = textValue,
        onValueChange = {
            textValue = it
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = LightPurple,
            focusedLabelColor = LightPurple,
            cursorColor = LightPurple,
        ),
        singleLine = true,
        label = {
            Text(text = labelValue)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(
    modifier: Modifier,
    labelValue: String,
) {

    var textValue by remember {
        mutableStateOf("")
    }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp)),
        value = textValue,
        onValueChange = {
            textValue = it
        },
        trailingIcon = {
            TextButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Text(text = if (isPasswordVisible) "Hide" else "Show", color = colorResource(id = R.color.text_medium))
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = LightPurple,
            focusedLabelColor = LightPurple,
            cursorColor = LightPurple,
        ),
        singleLine = true,
        label = {
            Text(text = labelValue)
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            autoCorrect = false,
            imeAction = ImeAction.Done,
        ),
    )
}


@Composable
fun SocialMediaLogin(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(2.dp, color = MaterialTheme.colorScheme.primary)
            .clip(RoundedCornerShape(4.dp))
            .clickable { onClick }
            .height(45.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
            color = BlueGray
        )
    }
}

@Preview
@Composable
fun SocialMediaLoginPreview() {
    SocialMediaLogin(icon = R.drawable.google_logo, text = "Login with Google") {
        
    }
}

