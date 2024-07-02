def solution(bridge_length, weight, truck_weights):
    time = 0
    bridge = [0] * bridge_length
    # 현재 다리 위 트럭의 무게
    current_bridge_weight = 0
    
    # 트럭이 전부 다리에 올라갈 때까지,
    while len(truck_weights) > 0:
        time += 1
        current_bridge_weight += truck_weights[0]
        
        # 대기 중인 트럭이 다리 위에 오르기 전 먼저 가장 앞에 있는 트럭을 떠나 보낸다.
        passed_truck_weight = bridge.pop(0)
        if passed_truck_weight != 0:
            current_bridge_weight -= passed_truck_weight
        
        # 현재 트럭 위 다리의 무게가 다리가 견딜 수 있는 무게를 초과하지 않는다면, 
        # 대기 중인 트럭을 다리 위에 올린다. 
        if (current_bridge_weight <= weight):
            bridge.append(truck_weights.pop(0))
        else:
            current_bridge_weight -= truck_weights[0]
            bridge.append(0)
    # 주의!!! 대기 중인 트럭 중 마지막 트럭이 다리 위에 올라간 후 지나갈 때까지의 시간 고려
    time += bridge_length
    return time