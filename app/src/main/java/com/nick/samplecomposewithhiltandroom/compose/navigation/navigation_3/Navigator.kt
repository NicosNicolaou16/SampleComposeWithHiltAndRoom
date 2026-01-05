package com.nick.samplecomposewithhiltandroom.compose.navigation.navigation_3

import androidx.navigation3.runtime.NavKey

/**
 * Handles navigation events (forward and back) by updating the navigation state.
 */
class Navigator(val state: NavigationState) {
    fun navigate(route: NavKey) {
        state.stacksInUse.add(route)
    }

    fun navigateToBottomNavItem(route: NavKey) {
        state.stacksInUse.clear()
        state.stacksInUse.add(route)
    }

    fun goBack() {
        state.stacksInUse.removeLastOrNull()
    }

    fun removeLast() {
        state.stacksInUse.removeLastOrNull()
    }
}