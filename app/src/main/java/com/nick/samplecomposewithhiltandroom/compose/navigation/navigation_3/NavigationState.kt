package com.nick.samplecomposewithhiltandroom.compose.navigation.navigation_3

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

/**
 * State holder for navigation state.
 *
 * @param backStacks - the back stacks for each top level route
 */
class NavigationState(
    val backStacks: NavBackStack<NavKey>
) {
    val stacksInUse: NavBackStack<NavKey>
        get() = backStacks
}