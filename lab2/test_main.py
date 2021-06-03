from main import CBC_DES_ENC, CBC_DES_DEC


def test_des():
    IV = [0] * 40 + [1] * 20 + [0] * 4
    text = "Secret Message"
    KEY = "1f4f8a113b4a5d66"
    cypher_text = CBC_DES_ENC(IV, text, KEY)
    original_text = CBC_DES_DEC(IV, cypher_text, KEY)
    assert ''.join(original_text).startswith(''.join(text))
