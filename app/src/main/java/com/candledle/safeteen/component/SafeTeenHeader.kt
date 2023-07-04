package com.candledle.safeteen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.candledle.safeteen.R
import com.candledle.safeteen.design_system.theme.Heading6

@Composable
internal fun SafeTeenHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(
                width = 22.dp,
                height = 30.dp,
            ),
            painter = painterResource(id = R.drawable.ic_safeteen_logo),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(12.dp))
        Heading6(text = stringResource(id = R.string.landing_safeteen))
    }
}