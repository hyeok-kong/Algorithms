from collections import Counter

def solution(nums):
    pockets = Counter(nums)
    return len(pockets) if len(pockets) < len(nums)//2 else len(nums)//2
