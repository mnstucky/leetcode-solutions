"use strict";

// https://leetcode.com/problems/sum-of-square-numbers/

let judgeSquareSum = function (c) {
    const map = new Map();
    let n = 0;
    while (n * n <= c) {
        let root = Math.sqrt(c - (n * n));
        if (Math.floor(root) === root) {
            return true;
        }
        n += 1;
    }
    return false;
};

judgeSquareSum(5);