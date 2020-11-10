"use strict";

// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/

var lengthOfLongestSubstring = function(s) {
    let result = 0;
    let startIdx = 0;
    const map = new Map();
    s.split("").forEach(function(val, endIdx) {
        if (map.has(val)) {
            result = (endIdx - startIdx > result) ? endIdx - startIdx : result;
            startIdx = map.get(val) + 1;
            const mapIter = map.keys();
            for (let i = 0; i < startIdx; i += 1) {
                let key = mapIter.next().value;
                if (map.get(key) < startIdx) {
                    map.delete(key);
                }
            }
        } else {
            result = (endIdx - startIdx + 1 > result) ? endIdx - startIdx + 1 : result;
        }
        map.set(val, endIdx);
    });
    return result;
};
