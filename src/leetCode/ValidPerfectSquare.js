"use strict";

// https://leetcode.com/problems/valid-perfect-square/

var isPerfectSquare = function (num) {
    if (Math.floor(Math.sqrt(num)) === Math.sqrt(num)) {
        return true;
    } else {
        return false;
    }
};