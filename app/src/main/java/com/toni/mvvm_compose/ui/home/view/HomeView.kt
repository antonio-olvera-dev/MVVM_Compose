import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.toni.mvvm_compose.R
import com.toni.mvvm_compose.shared.helpers.ResourcesHelper
import com.toni.mvvm_compose.ui.home.viewModel.HomeViewModel

@Composable
fun HomeView(ctx: Context, homeViewModel: HomeViewModel) {
    HomeComponents(ctx = ctx, homeViewModel = homeViewModel).Body()
}

private class HomeComponents(val ctx: Context, val homeViewModel: HomeViewModel) {

    private val res = ResourcesHelper(ctx = ctx)

    @Composable
    fun Body() {

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp, horizontal = 20.dp)) {

            DescriptionTop(modifier = Modifier.align(Alignment.TopStart))
            ActionsCenter(modifier = Modifier.align(Alignment.Center))
            DescriptionBottom(modifier = Modifier.align(Alignment.BottomEnd))
        }
    }

    @Composable
    fun DescriptionTop(modifier: Modifier) {
        Column(
            modifier = modifier
        ) {
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(text = res.getString(R.string.home_description_top))
        }
    }

    @Composable
    private fun ActionsCenter(modifier: Modifier) {

        val articleGetRequest by homeViewModel.articleGetRequest.observeAsState()

        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                ButtonDate(title = res.getString(R.string.home_button1),
                    value = articleGetRequest!!.startDate,
                    action = {
                        homeViewModel.setArticleGetRequest(startDate = "11111")
                    })

                Spacer(modifier = Modifier.padding(end = 40.dp))

                ButtonDate(title = res.getString(R.string.home_button2),
                    value = articleGetRequest!!.endDate,
                    action = {
                        homeViewModel.setArticleGetRequest(endDate = "22222")
                    })
            }

            ImageIcon(
                action = {
                    homeViewModel.setArticleGetRequest(startDate = "-1-1-1-1-1",
                        endDate = "-2-2-2-2-2")
                }
            )
        }
    }

    @Composable
    private fun ButtonDate(title: String, value: String, action: () -> Unit) {
        Column {
            Text(text = title)
            Spacer(modifier = Modifier.padding(top = 4.dp))
            Button(
                onClick = {
                    action()
                },
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )
            ) {
                Text(value)
            }
        }
    }

    @Composable
    private fun ImageIcon(action: () -> Unit) {

        val image: Painter = painterResource(id = R.drawable.ic_rocket)

        Spacer(modifier = Modifier.padding(top = 80.dp))
        Image(
            painter = image,
            contentDescription = res.getString(R.string.home_rocket_description),
            modifier = Modifier.clickable { action() }
        )
    }

    @Composable
    fun DescriptionBottom(modifier: Modifier) {
        Column(
            modifier = modifier
        ) {
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(text = res.getString(R.string.home_description_bottom))
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
        }
    }

}

