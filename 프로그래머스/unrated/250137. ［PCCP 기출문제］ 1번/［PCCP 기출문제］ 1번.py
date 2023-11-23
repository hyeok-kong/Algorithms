def solution(bandage, health, attacks):
    atts = {a[0]:a[1] for a in attacks}
    band_time, now = 0, health
    
    def heal(now, hp):
        res = health if now+hp > health else now+hp
        # print(res, hp)
        return res
        
    
    for time in range(attacks[-1][0] + 1):
        if time in atts:
            band_time = 0
            now -= atts[time]
            # print(time, now, band_time, True)
            if now <= 0:
                # print("end")
                now = -1
                break
            continue
        now = heal(now, bandage[1])
        band_time += 1
        if band_time == bandage[0]:
            now = heal(now, bandage[2])
            band_time = 0
        # print(time, now, band_time, False)
    return now