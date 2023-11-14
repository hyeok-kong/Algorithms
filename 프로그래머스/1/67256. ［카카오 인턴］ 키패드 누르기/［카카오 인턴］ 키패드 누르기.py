
def solution(numbers, hand):
    answer = ''
    keypad = [[1, 4, 7, '*'], [2, 5, 8, 0], [3, 6, 9, '#']]
    LEFT, MID, RIGHT = 0, 1, 2
    hand_position = [[LEFT, 3], [RIGHT, 3]]
    
    def distance(num):
        left = hand_position[0]
        right = hand_position[1]
        to = [1, keypad[1].index(num)]
        
        return abs(left[0]-to[0]) + abs(left[1]-to[1]), abs(right[0]-to[0]) + abs(right[1]-to[1])
    

    for number in numbers:
        if number in keypad[LEFT]:
            hand_position[0] = [LEFT, keypad[LEFT].index(number)]
            answer += 'L'
        elif number in keypad[RIGHT]:
            hand_position[1] = [RIGHT, keypad[RIGHT].index(number)]
            answer += 'R'
        else:
            l, r = distance(number)
            if l < r:
                hand_position[0] = [MID, keypad[MID].index(number)]
                answer += 'L'
            elif l > r:
                hand_position[1] = [MID, keypad[MID].index(number)]
                answer += 'R'
            else:
                if hand == 'left':
                    hand_position[0] = [MID, keypad[MID].index(number)]
                    answer += 'L'
                else:
                    hand_position[1] = [MID, keypad[MID].index(number)]
                    answer += 'R'

    return answer

