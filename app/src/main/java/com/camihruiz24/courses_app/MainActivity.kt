package com.camihruiz24.courses_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.camihruiz24.courses_app.data.model.Course
import com.camihruiz24.courses_app.data.model.DataSource
import com.camihruiz24.courses_app.ui.theme.CoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoursesApp()
                }
            }
        }
    }
}

@Composable
fun CoursesApp(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineLarge,
            fontFamily = FontFamily.Serif,
            modifier = modifier.padding(top = 8.dp),

        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(DataSource.courses) { course ->
                CourseCard(course = course)
            }
            items(DataSource.courses) { course ->
                CourseCard(course = course)
            }
        }
    }
}

@Composable
private fun CourseCard(course: Course, modifier: Modifier = Modifier) {
    Card(modifier) {
        Row(modifier) {
            Image(
                painter = painterResource(id = course.imageId),
                contentDescription = stringResource(id = course.titleId),
                modifier = Modifier.size(68.dp),
            )
            Column(modifier.padding(horizontal = 16.dp), horizontalAlignment = Alignment.Start) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = course.titleId),
                    style = MaterialTheme.typography.bodyMedium,
                )
                Row(modifier.padding(top = 8.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_associate),
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = course.associateCourses.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CourseCardPreview() {
    CourseCard(course = DataSource.courses[0])
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursesAppTheme {
        CoursesApp()
    }
}